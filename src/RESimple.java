import java.util.regex.Pattern;

public class RESimple {
    public static void main(String[] args) {
        String pattern ="\\S*";
                //"^(?<tag>[\\w_-]{2,40}) (?<hostname>\\S{20,}) \"(?<remoteaddr>[0-9]+\\.[0-9]+\\.[0-9]+\\.[0-9]+)\\|(?<upstreamaddr>\\S+)\\|(?<httpxforwardedfor>[-|\\s\\d\\.,]*)\" \\[(?<timelocal>.+)\\] \"(?<requesttime>\\d{1,}\\.\\d{3})\\|(?<upstreamconnecttime>\\S+)\\|(?<upstreamheadertime>\\S+)\\|(?<upstreamresponsetime>\\S+)\" \"(?<request>.+)\" (?<status>[0-9]+) (?<bodybytessent>[0-9]+) \"(?<cookiejsessionid>\\S*)\" \"(?<httpreferer>\\S+)\" \"(?<httpuseragent>.+)\"";//"^/apis/docenter/opp/ids/.+/fields/opp_wm_copyright,url";
                //"(?<remoteaddr>[0-9]+\\.[0-9]+\\.[0-9]+\\.[0-9]+)\\|(?<upstreamaddr>\\S+)\\|(?<httpxforwardedfor>[-|\\s\\d\\.,]*)";
                //"(?<remoteaddr>[0-9]+\\.[0-9]+\\.[0-9]+\\.[0-9]+)/(?<upstreamaddr>\\S+)/(?<httpxforwardedfor>^$|[-|\\s\\d\\.,]+)";
                //"^\\d+|(\\s&&[^\\f\\n\\r\\t\\v])*$";
                //"(?^$|/s<httpxforwardedfor>[-|\\s\\d\\.,]+)";
        String input = "";
                //"o_go2yd_com 103-33-69-sh-100-m08 \"123.59.122.171|10.103.35.59:8103|-\" [27/Apr/2018:07:35:07 +0800] \"0.006|0.000|0.002|0.002\" \"POST /open-api/lecalendar/real_time_log?timestamp=1524785717&api_id=Vzc3uAOBH8ij6FxTWL9RSQ0o&nonce=63fe5a67b53d2b89ecd37a585cdfc31c&secretkey=0c52ba4b3fb14cb5c465fbaad25bc3d1fdc8a9cb&yd_userid=-1438695726 HTTP/1.1\" 200 29 \"-\" \"\" \"Mozilla/5.0 (compatible; MSIE 10.0; Windows NT 6.1; Trident/6.0)\"";
        //"GET /Website/channel/news-list-for-best-channel?platform=1&fields%5B8%5D=image_urls&top_timestamp=0&fields%5B11%5D=dtype&fields%5B13%5D=docid&fields%5B0%5D=up&fields%5B15%5D=date&model=bbbssed&fields%5B2%5D=is_up&fields%5B17%5D=doc_authority&net=wifi&fields%5B4%5D=dislike_reasons&fields%5B19%5D=summary&fields%5B6%5D=like&cstart=0&_xm_=&refresh=-3&utk=-nmlbc842&version=020108&pushid=&fields%5B9%5D=image&fields%5B10%5D=title&fields%5B12%5D=url&cend=15&appid=oppobrowser&fields%5B14%5D=ctype&fields%5B1%5D=down&fields%5B16%5D=category&fields%5B3%5D=is_down&fields%5B18%5D=tags&only_new=true&fields%5B5%5D=comment_count&fields%5B7%5D=source HTTP/1.1";

        //"/apis/docenter/opp/ids/opp_qq_33bdaf90cfedcd7c0b75e0ba9d1722ab/fields/opp_wm_copyright,url";
                //"125.254.135.4|10.126.41.7:8101|-";
        Pattern p = Pattern.compile(pattern);

        boolean isTrue = p.matcher(input).find();
        System.out.println("'" + pattern + "' " + (isTrue ? " matches '" : "doesn't match '")  + "'");

    }
}
