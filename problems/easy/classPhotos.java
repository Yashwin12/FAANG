import java.util.*;

class Program {

  public boolean classPhotos(
      ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights) {
    
		Collections.sort( redShirtHeights );
		Collections.sort( blueShirtHeights );
					
		boolean frontRowRed = redShirtHeights.get(0) < blueShirtHeights.get(0);
		
		for( int i = 0; i < redShirtHeights.size(); i++ ){
			if( frontRowRed ){
				if( redShirtHeights.get(i) >= blueShirtHeights.get(i) )
					return false;
			}
			else{
				if( redShirtHeights.get(i) <= blueShirtHeights.get(i) )
					return false;
			}
		}
		
    return true;
  }
}
