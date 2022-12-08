package binaryproblem1;

/**
 *
 * @author pattr
 */
public class Tester
{
    public static void main(String[] args)
    {
        BinarySearch search = new BinarySearch();
        
        search.insertData(5);
        search.insertData(4);
        search.insertData(10);
        search.insertData(1);
        search.insertData(8);
        
        search.dft();
        
        search.bfs();
        
        search.bfsContain(4);
        
        //search.dfsContain(8);
    }
}
