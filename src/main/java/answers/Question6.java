package answers;


import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.regex.*;

public class Question6
{
    static int V;
    int minDistance(int dist[], Boolean sptSet[])
    {
        
        int min = Integer.MAX_VALUE, min_index=-1;
        
        for (int v = 0; v < V; v++)
            if (sptSet[v] == false && dist[v] <= min)
            {
                min = dist[v];
                min_index = v;
            }
        
        return min_index;
    }
    
    
    void printSolution(int dist[], int n)
    {
        
        
    }
    
    
    void shortPath(int graph[][], int src, int servertoReach)
    {
        int dist[] = new int[V];
        
        Boolean sptSet[] = new Boolean[V];
        
        
        for (int i = 0; i < V; i++)
        {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }
        
        
        dist[src] = 0;
        
        
        for (int count = 0; count < V-1; count++)
        {
            
            int u = minDistance(dist, sptSet);
            
            
            sptSet[u] = true;
            for (int v = 0; v < V; v++)
                
                if (!sptSet[v] && graph[u][v]!=0 &&
                    dist[u] != Integer.MAX_VALUE &&
                    dist[u]+graph[u][v] < dist[v])
                    dist[v] = dist[u] + graph[u][v];
        }
        System.out.println(dist[servertoReach]);
        
    }
    

    public static void main (String[] args)
    {
        Scanner user_input = new Scanner(System.in);
        String creditSwissInput;
        creditSwissInput = user_input.next();
        
        
        String firstSplit[] = creditSwissInput.split("\\[", 3);
        
       
        String initialInfos[] = firstSplit[1].split(",");
        
        
        int targetServer = 0;
        int serversAmounts = 0;
        
        targetServer = Integer.parseInt(initialInfos[1]);
        serversAmounts = Integer.parseInt(initialInfos[0]);
        
        
        int graph[][] = new int[serversAmounts][serversAmounts];
        
        ArrayList<String> serverDistances = new ArrayList<>();
        Matcher m = Pattern.compile("\\[(.*?)\\]").matcher(firstSplit[2]);
        
        while(m.find()) {
            
            serverDistances.add(m.group(1));
        }
        
        
        for(int z = 0;z<serversAmounts;z++) {
            String parts2[] = serverDistances.get(z).split(",");
            
            for(int i = 0;i<serversAmounts;i++) {
                
                graph[z][i] = Integer.parseInt(parts2[i]);
            }
        }
        
        
        V = graph.length;
        Question6 t = new Question6();
        t.shortPath(graph, 0, targetServer);
        
    }
}
