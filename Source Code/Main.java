import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	@SuppressWarnings("static-access")
	public static void main(String args[]) throws FileNotFoundException
	{
		File f1 =new File("karate_club_network.txt");
		int lenght=0;
		@SuppressWarnings("resource")
		Scanner sc =new Scanner(f1);
		while(sc.hasNextLine())
		{
			String line = sc.nextLine();
            String[] Nodes = line.split(" ");
            if(Integer.parseInt(Nodes[0])<Integer.parseInt(Nodes[1]))
            {
            	if(Integer.parseInt(Nodes[1])>lenght)
            		lenght=Integer.parseInt(Nodes[1]);
            }
            else
            {
            	if(Integer.parseInt(Nodes[0])>lenght)
            		lenght=Integer.parseInt(Nodes[0]);
            }
		}
		
		lenght++;
		
		Graph Graph=new Graph();
		Graph.Reset();
		ArrayList<ArrayList<Node>> Adjacency = new ArrayList<ArrayList<Node>>(lenght);
		
		for (int i = 0; i < lenght; i++) {
			Adjacency.add(new ArrayList<Node>());
		}
		
		
		File f =new File("karate_club_network.txt");
		@SuppressWarnings("resource")
		Scanner scan =new Scanner(f);
		while(scan.hasNextLine())
		{
			String line = scan.nextLine();
            String[] Nodes = line.split(" ");
            Node n1=new Node(Integer.parseInt(Nodes[0]));
            Node n2=new Node(Integer.parseInt(Nodes[1]));
            Graph.addEdge(Adjacency,n1,n2);
		}
		
		
		for (int i = 1; i < Adjacency.size(); i++) {
			for (int j = 1; j < Adjacency.size(); j++) {
				if(i!=j)
				{
					Node First=new Node(i);
					Node Second=new Node(j);
					Graph.printShortestPath(Adjacency, First, Second, lenght);
				}
				
			}
			
		}
		System.out.println("Karate Club Network");
		Graph.Find_Betweenes(lenght);
		Graph.Find_Closeness(lenght);
		Graph.Reset();
		
		System.out.println();
		
		// use CTRL+7 to make the bottom part work again
		
		
		
		
		
		
//		File f2 =new File("facebook_social_network.txt");
//		int lenght2=0;
//		@SuppressWarnings("resource")
//		Scanner sc2 =new Scanner(f2);
//		while(sc2.hasNextLine())
//		{
//			String line = sc2.nextLine();
//            String[] Nodes = line.split(" ");
//            if(Integer.parseInt(Nodes[0])<Integer.parseInt(Nodes[1]))
//            {
//            	if(Integer.parseInt(Nodes[1])>lenght2)
//            		lenght2=Integer.parseInt(Nodes[1]);
//            }
//            else
//            {
//            	if(Integer.parseInt(Nodes[0])>lenght2)
//            		lenght2=Integer.parseInt(Nodes[0]);
//            }
//		}
//		
//		lenght2++;
//		
//		Graph Graph2=new Graph();
//		ArrayList<ArrayList<Node>> Adjacency2 = new ArrayList<ArrayList<Node>>(lenght2);
//		
//		for (int i = 0; i < lenght2; i++) {
//			Adjacency2.add(new ArrayList<Node>());
//		}
//		
//		
//		File f3 =new File("facebook_social_network.txt");
//		@SuppressWarnings("resource")
//		Scanner scan2 =new Scanner(f3);
//		while(scan2.hasNextLine())
//		{
//			String line = scan2.nextLine();
//            String[] Nodes = line.split(" ");
//            Node n1=new Node(Integer.parseInt(Nodes[0]));
//            Node n2=new Node(Integer.parseInt(Nodes[1]));
//            Graph2.addEdge(Adjacency2,n1,n2);
//		}
//		
//		
//		for (int i = 1; i < Adjacency2.size(); i++) {
//			for (int j = 1; j < Adjacency2.size(); j++) {
//				if(i!=j)
//				{
//					Node First=new Node(i);
//					Node Second=new Node(j);
//					Graph.printShortestPath(Adjacency2, First, Second, lenght2);
//				}
//				
//			}
//			
//		}
//		System.out.println("FaceBook Social Network");
//		Graph2.Find_Betweenes(lenght2);
//		Graph2.Find_Closeness(lenght2);
	}

	
}
