package Questions;// Matrix.java

// Matrix class implementation
public class Matrix {
    
    // private data members to store rows, columns and 2d array
    private int rows;
    private int columns;
    private double[][] elements;
    
    // parameterized constructor to initialize row and column values
    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        elements = new double[rows][columns];
    }
    
    // Returns the matrix product of a and b
    public static Matrix product(Matrix a, Matrix b) {
        // validate dimensions for matrix multiplication
        // the number of columns in first matrix should be equal to number of rows in the second matrix
        assert (a.columns == b.rows);
        
        // create a new Matrix object of size rows * columns for product of two matrices
        Matrix result = new Matrix(a.rows, b.columns);
        
        // computing the product using double for loop
        for (int i = 0; i < a.rows; ++i) {
            double[] resultRow = result.elements[i];
            double[] aRow = a.elements[i];
            for (int j = 0; j < a.columns; ++j) {
                double[] bRow = b.elements[j];
                for (int k = 0; k < b.columns; ++k) resultRow[k] += aRow[j] * bRow[k];
            }
        }
        
        // return the product of two matrices
        return result;
    }
    
    // setter function to set array elements
    public void set(int row, int column, double value) {
        elements[row][column] = value;
    }
    
    // getter function to return value stored in given index of matrix
    public double get(int row, int column) {
        return elements[row][column];
    }
    
    // function to print the matrix
    public void print() {
        // looping through the records using nested for loop
        for (int row = 0; row < rows; ++row) {
            for (int column = 0; column < columns; ++column) {
                if (column > 0) System.out.print(' ');
                System.out.printf("%7.3f", elements[row][column]);
            }
            // printing a new line at the end of each row
            System.out.println();
        }
    }
    
    // Returns the inverse of this matrix
    public Matrix inverse() {
        // validate that the matrix is a square matrix
        // as the inverse of a square matrix can be computed only for a square matrix
        assert (rows == columns);
        // Augment by identity matrix
        
        // create a new augmented matrix of size rows * (rows * 2)
        Matrix tmp = new Matrix(rows, columns * 2);
        for (int row = 0; row < rows; ++row) {
            System.arraycopy(elements[row], 0, tmp.elements[row], 0, columns);
            tmp.elements[row][row + columns] = 1;
        }
        // reducing the augmented matrix to Row Echelon Form
        tmp.toReducedRowEchelonForm();
        
        // create a new Matrix object of size rows * columns for inverse of the matrix
        Matrix inv = new Matrix(rows, columns);
        
        // transfer the elements from the temporary augmented matrix to output inverse matrix
        for (int row = 0; row < rows; ++row)
            System.arraycopy(
                    tmp.elements[row],
                    columns,
                    inv.elements[row],
                    0,
                    columns
            );
        
        // return the inverse of the matrix
        return inv;
    }
    
    // Converts this matrix into reduced row echelon form
    public void toReducedRowEchelonForm() {
        for (int row = 0, lead = 0; row < rows && lead < columns; ++row, ++lead) {
            int i = row;
            while (elements[i][lead] == 0) {
                if (++i == rows) {
                    i = row;
                    if (++lead == columns) return;
                }
            }
            swapRows(i, row);
            if (elements[row][lead] != 0) {
                double f = elements[row][lead];
                for (
                        int column = 0;
                        column < columns;
                        ++column
                )
                    elements[row][column] /= f;
            }
            for (int j = 0; j < rows; ++j) {
                if (j == row) continue;
                double f = elements[j][lead];
                for (int column = 0; column < columns; ++column)
                    elements[j][column] -=
                            f * elements[row][column];
            }
        }
    }
    
    // helper function to swap two rows in matrix
    private void swapRows(int i, int j) {
        double[] tmp = elements[i];
        elements[i] = elements[j];
        elements[j] = tmp;
    }
}
