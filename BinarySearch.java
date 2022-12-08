package binaryproblem1;

/**
 * This is the search tree for the Binary Tree Problem 1
 *
 * @author Patrick Trahan
 */
public class BinarySearch<E extends Comparable<E>>
{

    private Node root;
    private String preOrderOutput = "";
    private String inOrderOutput = "";
    private String postOrderOutput = "";
    private E targetValue;

    /**
     * Is a blank constructor Don't really use it only so I can call into this
     * program
     */
    public BinarySearch()
    {

    }

    /**
     * This is the method that the main method calls and all it does is calls a
     * same but different method that has the Node in it
     *
     * @param data is the value that is being added to the tree
     */
    public void insertData(E data)
    {
        root = insertData(root, data);
    }

    /**
     * This is the method to insert data into the tree.
     *
     * @param tree is the binary search tree
     * @param data is the value that is being inserted into the tree
     * @return the new tree
     */
    public Node insertData(Node tree, E data)
    {
        if (tree == null)
        {
            //creates the root tree with the data
            tree = new Node(data);
        } else
        {
            //had to make a variable to store the data of the root tree
            E rootData = (E) tree.getData();

            //the if checks to see if the data is the same as the root data
            if (data.compareTo(rootData) == 0)
            {
                System.out.println("Cannot add value is equal to the Root data");
            } // checks to see if the data is less than the root which means add it to the left
            else if (data.compareTo(rootData) < 0)
            {
                //recurvsively calls the left till it is at the correct position
                tree.setLeft(insertData(tree.leftTree(), data));
            } // checks to see if the data is greater than the root which means add it to the right
            else
            {
                //recurvsively calls the right till it is at the correct position
                tree.setRight(insertData(tree.rightTree(), data));
            }
        }
        return tree;
    }

    /**
     * This is the method that the main method calls and will just call the
     * method with the tree as a parameter
     *
     * @param target is the targeted value that is to be deleted from the tree
     */
    public void remove(E target)
    {
        root = remove(root, target);
    }

    /**
     * This method is to remove the targeted value from the tree
     *
     * @param tree is the binary search tree
     * @param target is the targeted value that is to be removed
     * @return the new tree
     */
    public Node remove(Node tree, E target)
    {
        if (tree == null)
        {
            System.out.println("Tree is null nothing to remove");
        }

        //had to do this so it will cast the tree.getData() correctly
        //somehow inside the if statement it would not work
        E compareData = (E) tree.getData();

        //the targeted value is less so move to the left tree
        if (target.compareTo(compareData) < 0)
        {
            tree.setLeft(remove(tree.leftTree(), target));
        } //the targeted value is greater so move to the right of the tree
        else if (target.compareTo(compareData) > 0)
        {
            tree.setRight(remove(tree.rightTree(), target));
        } else
        {
            //found the location of the value that you want to remove
            //now have to replace the value

            //if there is no left child tree
            if (tree.leftTree() == null)
            {
                //return the right child tree
                return tree.rightTree();
            } //if there is no right child tree
            else if (tree.rightTree() == null)
            {
                //return the left child tree
                return tree.leftTree();
            } //if there are two child trees
            else
            {
                //the right child is null 
                if (tree.leftTree().rightTree() == null)
                {
                    //replace the targeted value with the child
                    tree.setData(tree.leftTree().getData());
                    tree.setLeft(tree.leftTree().leftTree());
                } else
                {
                    //the opposite of the steps above
                    tree.setData(tree.rightTree().getData());
                    tree.setRight(tree.rightTree().rightTree());
                }
            }
        }
        return tree;
    }

    /**
     * Will store a string of the preorder traversal of the search tree will
     * recursively do so
     *
     * @param tree the binary search tree
     * @return the output as a string
     */
    public String preOrder(Node tree)
    {
        if (tree != null)
        {
            //stores the value in the string
            preOrderOutput = preOrderOutput + tree.getData() + " ";

            //recursively calls the left tree
            preOrder(tree.leftTree());

            //recursively calls the right tree
            preOrder(tree.rightTree());
        }
        return preOrderOutput;
    }

    /**
     * Will store a string of the inorder traversal of the binary search tree
     * will recursively do so
     *
     * @param tree the binary search tree
     * @return the output as a string
     */
    public String inOrder(Node tree)
    {
        if (tree != null)
        {
            //recursively calls the left tree
            inOrder(tree.leftTree());

            //stores the value as a string
            inOrderOutput = inOrderOutput + tree.getData() + " ";

            //recursively calls the right tree
            inOrder(tree.rightTree());
        }
        return inOrderOutput;
    }

    /**
     * Will store a string of the post order traversal of the binary search tree
     * will recursively do so
     *
     * @param tree the binary search tree
     * @return the output as a string
     */
    public String postOrder(Node tree)
    {
        if (tree != null)
        {
            //recursively calls the left tree
            postOrder(tree.leftTree());

            //recursively calls the right tree
            postOrder(tree.rightTree());

            //stores the value as a string
            postOrderOutput = postOrderOutput + tree.getData() + " ";
        }
        return postOrderOutput;
    }

    /**
     * The method to print out all of the Depth First Search
     */
    public void dft()
    {
        if (root != null)
        {
            System.out.println("Pre Order: ");
            System.out.println(preOrder(root));

            System.out.println("In Order: ");
            System.out.println(inOrder(root));

            System.out.println("Post Order: ");
            System.out.println(postOrder(root));
        } else
        {
            System.out.println("Tree is null");
        }
    }

    public void bfs()
    {
        if (root != null)
        {
            System.out.println("Breadth First Search: ");
            bfs(root);
            System.out.println();
        } else
        {
            System.out.println("Tree is emtpy");
        }
    }

    public void bfs(Node tree)
    {
        if (tree != null)
        {
            System.out.print(tree.getData() + " ");
            if (tree.leftTree() != null)
            {
                System.out.print(tree.leftTree().getData() + " ");
                remove(tree, (E) tree.leftTree().getData());
            }
            if (tree.rightTree() != null)
            {
                System.out.print(tree.rightTree().getData() + " ");
                remove(tree, (E) tree.rightTree().getData());
            }

            bfs(tree.leftTree());
            bfs(tree.rightTree());
        }
    }

    public void dfsContain(E target)
    {
        System.out.println("Does the tree contain " + target + ": " + dfsCheck(root, target));
    }
    
    public boolean dfsCheck(Node tree, E target)
    {
        if (tree != null)
        {
            E temp = (E) tree.getData();
            System.out.println("data type is " + temp.getClass().getSimpleName());
            if(target.equals(temp))
            {
                return true;
            }
            
            dfsCheck(tree.leftTree(), target);
            dfsCheck(tree.rightTree(), target);
        }
        return false;
    }
    
    public void bfsContain(E target)
    {
        System.out.println("Does the tree contain " + target + ": " + bfsCheck(target));
    }
    
    public boolean bfsCheck(E target)
    {
        E temp;
        
        if (root != null)
        {
            temp = (E) root.getData();
            if(target.equals(temp))
            {
                return true;
            }
            
            if (root.leftTree() != null)
            {
                temp = (E) root.leftTree().getData();
                if(target.equals(temp))
                {
                    return true;
                }
                
                remove(root, (E) root.leftTree().getData());
            }
            if (root.rightTree() != null)
            {
                temp = (E) root.rightTree().getData();
                if(target.equals(temp))
                {
                    return true;
                }
                remove(root, (E) root.rightTree().getData());
            }

            bfs(root.leftTree());
            bfs(root.rightTree());
        }  
        return false;
    }
}
