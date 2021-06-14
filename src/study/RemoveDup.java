import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RemoveDup {

	public static void main(String[] args) {
		List<Music> list = new ArrayList<Music>();
		list.sort((a, b) -> a.played - b.played);
		
		List<Music> removed = list.stream().distinct().collect(Collectors.toList());
		
		Set<Music> set = new HashSet<Music>();
		
		
		// int array to Integer array
		int[] arr = {1, 2, 3, 4, 5};
		Integer ints[] = Arrays.stream(arr).boxed().toArray(Integer[]::new); 
		  
		// array to list to set
		List<Integer> iList = Arrays.asList(ints);
		Set<Integer> iSet = new TreeSet<Integer>(iList);
		
		
		int[] data = {1,2,3,4,5,6,7,8,9,10};
		// To boxed array
		Integer[] what = Arrays.stream( data ).boxed().toArray( Integer[]::new );
		Integer[] ever = IntStream.of( data ).boxed().toArray( Integer[]::new );

		// To boxed list
		List<Integer> you  = Arrays.stream( data ).boxed().collect( Collectors.toList() );
		List<Integer> like = IntStream.of( data ).boxed().collect( Collectors.toList() );
	}
	
	static class Music {
	    String genre;
	    int played, id;
	
	    public Music(String genre, int played, int id) {
	      this.genre = genre;
	      this.played = played;
	      this.id = id;
	    }
	    
	    @Override
	    public boolean equals(Object a) {
	    	Music obj = (Music) a;
	        return (obj.genre == this.genre && obj.id == this.id);
	    }

	    @Override
	    public int hashCode() {
	        return (genre + id).hashCode();
	    }
	    // https://dydtjr1128.github.io/java/2019/04/25/JAVA-Hash.html
	}

}
