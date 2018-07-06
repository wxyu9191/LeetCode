# -*- coding: utf-8 -*-

import MySQLdb as mab
import time
import gevent
tag = {
    "host": "10.103.17.12",
    "port": 3306,
    "user": "ydop",
    "password": "ydop",
    "database": "ydop",
    "charset": "utf-8"
}
DELAY_TIME = 60

con = mab.connect(tag["host"], port=tag["port"], user=tag["user"], passwd=tag["password"], db=tag["database"])
cursor = con.cursor(mab.cursors.DictCursor)


def get_timestamp():
    return int(time.time())


class AlertDataSource():
    def __init__(self):
        pass

    @classmethod
    def get_datasources(cls, datasource_id):
        sql = "select * from %s where id = %d" % ('alert_config_alertdatasource', datasource_id)
        cursor.execute(sql)
        databases = cursor.fetchall()
        return databases

    @classmethod
    def handle(cls, alert_config):
        datasource_id = alert_config["datasource_id"]
        print datasource_id
        datasource = AlertDataSource.get_datasources(datasource_id)
        #print datasource
        datasource_address = datasource[0]['address']
        db_name = datasource[0]['db_name']
        db_type = datasource[0]['db_type']
        print datasource_address, db_name, db_type


def dosth():
    #x = AlertDataSource.get_datasources()
    sql = "select * from %s" % ('alert_config_alertdatasource')
    cursor.execute(sql)
    x = cursor.fetchall()


class AlertConfig():

    #获取所有判定策略
    @classmethod
    def get_alert_configs(cls):
        sql = "select * from %s" %('alert_config_alertconfig')
        cursor.execute(sql)
        return cursor.fetchall()





if __name__ == '__main__':
    #多久去检查一次是否 触发报警 根据DELAY_TIME
    def alert_handle(alert_config):
        cache = {}
        print alert_config["id"]
        if (alert_config["id"] not in cache):
            cache.update({alert_config["id"]: 1})
        else:
            temp = cache.get(alert_config["id"])
            cache.update({alert_config["id"]: temp + 1})
        if cache.get(alert_config["id"]) * DELAY_TIME >= alert_config["interval"]:
            AlertDataSource.handle(alert_config)

        #循环判定，一定时间内进行一次判定，报警表达式和数据源进行比较满足就报警
    while True:
        #取出所有判断表达式
        alert_configs = AlertConfig.get_alert_configs()
        greenlets = []
        #print len(alert_configs)
        for alert_config in alert_configs:
            #print alert_config
            greenlet = gevent.spawn(alert_handle, alert_config);
            greenlets.append(greenlet)
            #print '----------------'
            # print alert_config["expression"]
            # print alert_config["datasource_id"]
        gevent.killall(greenlets)
        cursor.close()
        con.close()
        break