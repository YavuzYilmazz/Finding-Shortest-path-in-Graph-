import java.util.ArrayList;

public class Graph {
		public static int Betweennes[]=new int[2000];
		public static int Closenees[]=new int[2000];
		
		public void addEdge(ArrayList<ArrayList<Node>> Adjacency, Node i, Node j)
		{
			Adjacency.get(i.getData()).add(j);
			Adjacency.get(j.getData()).add(i);
		}

		public static void printShortestPath(ArrayList<ArrayList<Node>> Adjacency,Node Source, Node Destination, int lenght)
		{

			Node priority[] = new Node[lenght];
			Node distance[] = new Node[lenght];

			if (!BFS(Adjacency, Source, Destination, lenght, priority, distance)) {
				//System.out.println("Given source and destination are not connected");
				return;
			}


			ArrayList<Node> Path = new ArrayList<Node>();
			Node advance =Destination;
			Path.add(advance);
			while (priority[advance.getData()].getData() != -1) {
				Path.add(priority[advance.getData()]);
				advance = priority[advance.getData()];
			}


			Closenees[Source.getData()-1]+=distance[Destination.getData()].getData();
			
			for (int i = Path.size() - 1; i >= 0; i--) {
				if(i!=Path.size()-1&&i!=0&&Source.getData()<Destination.getData())
					Betweennes[Path.get(i).getData()-1]++;
			}
			
			
		}
		
		public void Find_Betweenes(int Lenght)
		{

			int max = Betweennes[0];
	        int index=1;
	        for (int i = 0; i < Lenght; i++){
	            if (Betweennes[i] > max) {
	            	max = Betweennes[i];
	            	index=i+1;
	            }
	        }
	        
	        System.out.println("The Highest Node for Betweeness: " + index+" Value: "+max);
		}
		
		public void Find_Closeness(int Lenght) {
			
			int max = Integer.MAX_VALUE;
	        int index=1;
	        for (int i = 0; i < Lenght; i++){
	            if (Closenees[i] < max && Closenees[i]>1) {
	            	max = Closenees[i];
	            	index=i+1;
	            }
	        }
	        System.out.println("The Highest Node for Closenees: " + index+" Value: "+ ((double)1 / max));
		}
		
		public void Reset() {
			for (int i = 0; i < Betweennes.length; i++) {
				Betweennes[i]=0;
				Closenees[i]=0;
			}
			
		}
		
		
		public static boolean BFS(ArrayList<ArrayList<Node>> Adjacency, Node Source,
									Node Destination, int lenght, Node Priority[], Node Distance[])
		{
			ArrayList<Integer> BFS=new ArrayList<Integer>();

			boolean IsVisited[] = new boolean[lenght];

			for (int i = 0; i < lenght; i++) {
				IsVisited[i] = false;
				Distance[i] = new Node(Integer.MAX_VALUE);
				Priority[i] = new Node(-1);
			}


			IsVisited[Source.getData()] = true;
			Distance[Source.getData()] = new Node(0);
			BFS.add(Source.getData());

			while (!BFS.isEmpty()) {
				Node rmv=new Node(0);
				int u = BFS.remove(rmv.getData());
				for (int i = 0; i < Adjacency.get(u).size(); i++) {
					if (IsVisited[Adjacency.get(u).get(i).getData()] == false) {
						IsVisited[Adjacency.get(u).get(i).getData()] = true;
						Distance[Adjacency.get(u).get(i).getData()].setData(Distance[u].getData() + 1);
						Priority[Adjacency.get(u).get(i).getData()].setData(u);
						BFS.add(Adjacency.get(u).get(i).getData());

						if (Adjacency.get(u).get(i).getData() == Destination.getData())
							return true;
					}
				}
			}
			return false;
		}
		}

		


