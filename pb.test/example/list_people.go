package main

import (
	"io"
	"fmt"
	pb "../protofile"
	"os"
	"log"
	"io/ioutil"
	"github.com/gogo/protobuf/proto"
)

func writePerson(w io.Writer, p *pb.Person){
	fmt.Fprintln(w, "Person ID:", p.Id)
	fmt.Fprintln(w, "  Name:", p.Name)
	if p.Email != ""{
		fmt.Fprintln(w, " E-mail address:", p.Email)
	}

	for _, pn := range p.Phones {
		switch pn.Type {
		case pb.Person_MOBILE:
			fmt.Fprint(w, " Moblie phone #:")
		case pb.Person_HOME:
			fmt.Fprint(w, " Home phone #:")
		case pb.Person_WORKER:
			fmt.Fprint(w, " Worker phone #:")
		}
		fmt.Fprintln(w, pn.Number)
	}
}

func listPeople(w io.Writer, book *pb.AddressBook)  {
	for _, p := range book.People{
		writePerson(w, p)
	}
}

func main()  {
	if len(os.Args) != 2 {
		log.Fatalf("Usage: %s ADDRESS_BOOK_FILE\n")
	}
	fname := os.Args[1]

	in, err := ioutil.ReadFile(fname)
	if err != nil{
		log.Fatalln("Error reading file: ",err)
	}
	book := &pb.AddressBook{}
	if err := proto.Unmarshal(in, book); err != nil {
		log.Fatalln("Failed to parse address book: ",err)
	}

	listPeople(os.Stdout, book)
}