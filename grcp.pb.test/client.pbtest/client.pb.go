package main

import (
	"google.golang.org/grpc"
	"fmt"
	sb "grcp.pb.test/data.pbtest"
)

const address  = "127.0.0.1:14148"

/**
 first. create a grpc connector
 second. create a grpc client,and take the connector to it
 third. send a request to the grpc server
	*/
func main()  {
	//create a grpc connector
	conn, err := grpc.Dial(address, grpc.WithInsecure())
	if err != nil{
		fmt.Print(err)
	}
	//remember to close the connect when the request has done,unless it will be cost resource
	defer conn.Close()

	//create a grpc client
	c := sb.NewInterviewClient(conn)
	fmt.Fprintln(c)
}