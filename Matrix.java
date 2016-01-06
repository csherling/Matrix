/*
  Christopher Sherling
  APCS1 pd5
  HW54 -- Red vs Blue
  2016-01-06
*/

/*====================================
  class Matrix -- models a square matrix

  TASK: Implement methods below.
  Categorize runtime of each. 
  Test in your main method.
  ====================================*/ 

public class Matrix {

    //constant for default matrix size
    private final static int DEFAULT_SIZE = 2;

    private Object[][] matrix;


    //default constructor intializes a DEFAULT_SIZE*DEFAULT_SIZE matrix
    public Matrix() {
	matrix = new Object[DEFAULT_SIZE][DEFAULT_SIZE];
    } 
    //O(1)

    //constructor intializes an a*a matrix
    public Matrix( int a ) {
      	matrix = new Object[a][a];
    }
    //O(1)

    //return size of this matrix, where size is 1 dimension
    private int size() {
	return matrix[0].length;
    }
    //O(1)

    //return the item at the specified row & column   
    private Object get( int r, int c ) {
	return matrix[r][c];
    }
    //O(1)

    //return true if this matrix is empty, false otherwise
    private boolean isEmpty( int r, int c ) {
	return matrix[r][c] == null;
    }
    //O(1)

    //overwrite item at specified row and column with newVal
    //return old value
    private Object set( int r, int c, Object newVal ) {
	Object temp = matrix[r][c];
	matrix[r][c] = newVal;
	return temp;
    }
    //O(1)

    //return String representation of this matrix
    // (make it look like a matrix)
    public String toString() {
	String info = "";
	for(Object[] oa: matrix){
	    for(Object o: oa){
		info += o + " ";
	    }
	    info += "\n";
	}
	return info;	
    }
    //O(n^2)

    //override inherited equals method
    //criteria for equality: matrices have identical dimensions,
    // and identical values in each slot

    public boolean equals( Object rightSide ) {
	if(!(rightSide instanceof Matrix)){
	    return false;
	}
	if(this.size() != ((Matrix)rightSide).size()){
	    return false;
	}
	for(int r = 0; r < this.size(); r++){
	    for(int c = 0; c < this.size(); c++){
		if(!(matrix[r][c].equals((((Matrix)rightSide).get(r, c))))){
		    return false;
		}
	    }
	}
	return true;       
    }
    //O(n^2)

    //swap two columns of this matrix 
    //(1,1) is top left corner of matrix
    //row values increase going down
    //column value increase L-to-R
    public void swapColumns( int c1, int c2  ) {
	for(int r = 0; r < this.size(); r++){
	    this.set(r, c1, this.set(r, c2, this.get(r, c1)));
	}	
    }
    //O(n)

    //swap two rows of this matrix 
    //(1,1) is top left corner of matrix
    //row values increase going down
    //column value increase L-to-R
    public void swapRows( int r1, int r2  ) {
	for(int c = 0; c < this.size(); c++){
	    this.set(r1, c, this.set(r2, c, this.get(r1, c)));
	}
    }
    //O(n)

    //main method for testing
    public static void main( String[] args ) {
	Matrix martin = new Matrix();
	System.out.println("empty martin");
	System.out.println(martin);
	System.out.println("isEmpty 1, 1");
	System.out.println(martin.isEmpty(1, 1));
	martin.set(0,0,5);
	martin.set(1,0,5);
	martin.set(0,1,5);
	martin.set(1,1,5);
	System.out.println("populated martin");
	System.out.println(martin);


	Matrix carson = new Matrix();
	System.out.println("empty carson");
	System.out.println(carson);
	carson.set(0,0,5);
	carson.set(1,0,5);
	carson.set(0,1,5);
	carson.set(1,1,4);
	System.out.println("populated carson");
	System.out.println(carson);

	Matrix brian = new Matrix(3);
	System.out.println("empty brian");
	System.out.println(brian);
	brian.set(0,0,5);
	brian.set(1,0,5);
	brian.set(2,0,5);
	brian.set(0,1,5);
	brian.set(1,1,5);
	brian.set(2,1,5);
	brian.set(0,2,5);
	brian.set(1,2,5);
	brian.set(2,2,5);
	System.out.println("populated brian");
	System.out.println(brian);

	System.out.println("martin equals carson");
	System.out.println(martin.equals(carson));
	System.out.println("martin equals carson intentional true");
	carson.set(1,1,5);
	System.out.println(martin.equals(carson));
	System.out.println("martin equals brian");
	System.out.println(martin.equals(brian));

	carson.set(1,1,4);
	System.out.println("wait, what's carson again?");
	System.out.println(carson);
	carson.swapRows(0, 1);
	System.out.println("swap rows of carson");
	System.out.println(carson);
	carson.swapColumns(0, 1);
	System.out.println("swap columns of carson");
	System.out.println(carson);

    }

}//end class Matrix
