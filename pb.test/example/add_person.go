package main

import (
	"io"
	pb "../protofile"
	"bufio"
	"fmt"
	"strings"
	"os"
	"log"
	"io/ioutil"
	"github.com/gogo/protobuf/proto"
)

func promptForAddress(r io.Reader)(*pb.Person, error)  {
	p := &pb.Person{}

	rd := bufio.NewReader(r)
	fmt.Print("Enter person ID number: ")
	if _, err := fmt.Fscanf(rd, "%d\n", &p.Id); err != nil{
		return p, err
	}

	fmt.Print("Enter name: ")
	name, err := rd.ReadString('\n')
	if err != nil{
		return p, err
	}

	p.Name = strings.TrimSpace(name)

	fmt.Print("Enter email address (blank for none): ")
	email, err := rd.ReadString('\n')
	if err != nil {
		return p, err
	}
	p.Email = strings.TrimSpace(email)

	//
	for {
		fmt.Print("Enter a phone number (or leave blank to finsh): ")
		phone, err := rd.ReadString('\n')
		if err != nil{
			return p, nil
		}
		phone = strings.TrimSpace(phone)
		if phone=="" {
			break
		}

		pn := &pb.Person_PhoneNumber{
			Number: phone,
		}

		fmt.Print("Is this a mobile, home, or work phone? ")
		ptype, err := rd.ReadString('\n')
		if err != nil {
			return p, err
		}
		ptype = strings.TrimSpace(ptype)

		switch ptype {
		case "mobile":
			pn.Type = pb.Person_MOBILE
		case "home":
			pn.Type = pb.Person_HOME
		case "work":
			pn.Type = pb.Person_WORKER
		default:
			fmt.Print("Unknown phone type %q. Using default. \n", ptype)
		}

		p.Phones = append(p.Phones, pn)
	}
	return p, nil
}

func main()  {
	if len(os.Args) != 2 {
		log.Fatalf("Usage: %s ADDRESS_BOOK_FILE\n", os.Args[0])
	}
	fname := os.Args[1]

	in, err := ioutil.ReadFile(fname)
	if err != nil {
		if os.IsNotExist(err) {
			fmt.Printf("%s: File not found. Creating new file.\n", fname)
		}else {
			log.Fatalln("Error reading file:", err)
		}
	}

	//start  marshel proto
	book := &pb.AddressBook{}

	if err := proto.Unmarshal(in, book); err != nil{
		log.Fatalln("Failed to parse address book:", err)
	}

	//add an address
	addr, err := promptForAddress(os.Stdin)
	if err != nil{
		log.Fatalln("Error with address:", err)
	}
	book.People = append(book.People, addr)


	//write the new address book back to disk
	out, err := proto.Marshal(book)
	fmt.Printf("now is here")
	if err != nil{
		log.Fatalln("Failed to encode address book:", err)
	}
	//序列化，写进文件
	if err := ioutil.WriteFile(fname, out, 0644); err != nil {
		log.Fatalln("Failed to write address book:" , err)
	}
}
