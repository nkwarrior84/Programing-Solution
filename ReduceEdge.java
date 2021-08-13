class ReduceEdge {
  static int T, N, M, ans;
  static int[][] map;
  static int[] visitCount;
  static Queue<Integer> queue = new LinkedList<Integer>();
  
  public static void main(String[] args) {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    
    StringTokenizer st;
    T = Integer.parseInt(in.readLine());
    for (int t = 1; t <= T; t++) {
      st = new StringTokenizer(in.readLine());
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
      ans = M;
      map = new int[N][N];
      
      for (int i=0; i<M; i++) {
        st = new StringTokenizer(in.readLine());
        int from = Integer.parseInt(st.nextToken()) - 1;
        int to = Integer.parseInt(st.nextToken()) - 1;
        map[from][to] = 1;
      }
      
      for (int i=0; i<N; i++) {
        visitCount = new int[N];
        BFS(i);
        
        for (int j=0; j<N; j++) {
          if(visitCount[j] > 1 && map[i][j] == 1) {
            ans--;
            map[i][j] = 0;
          }
        }
       out.write("#" + t + " " + ans + "\n"); 
      }
    }
    out.flush();
  }
  
  public static void BFS(int idx) {
    visitCount[idx]++;
    queue.add(idx);
    
    while(!queue.isEmpty()) {
      Integer nextIdx = queue.poll();
      for (int i=0; i<N; i++) {
        
        if(map[nextIdx][i] == 0) 
          continue;
        
        if(visitCount[i] > 1)
          continue;
        
        queue.add(i);
        visitCount[i]++;
      }
    }
  }
}
