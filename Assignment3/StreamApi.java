package Assignment3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApi {
    //stream is interface we can't make object of it but can get object from n no of methods
    //stream Api--collection process
    //collection / group of objects
    public static void main(String[] args) {
        List<Integer>list1=new ArrayList<>();
        list1.add(12);
        list1.add(13);
        list1.add(15);
        list1.add(18);
        //Find even without stream

//        List<Integer>newList=new ArrayList<>();
//        for(int i:list1)
//        {
//            if(i%2==0)
//            {
//                newList.add(i);
//            }
//        }
//        System.out.println(newList);

        //with Stream
        List<Integer>newList= list1.stream().filter(i->i%2==0).collect(Collectors.toList());
        System.out.println(newList);

        //object of stream
        Stream<Integer>stream =list1.stream();
        stream.forEach(e->{
            System.out.print(e);
        });

    }
}
