public class Diagonal {
    public static void main(String args[]) {
        // char[] x = { 'w', 'h', 'a', 't', 's', '.', 'u', 'p', 's' };
        // int rows = 3;
        // int cols = 3;
        // char[] x = { 
        //     'w', 'h', 'a',
        //     't', 's', ' ',
        //     'u', 'p', ' ',
        //     's', 'o', 'n'
        // };
        // int rows = 4;
        // int cols = 3;
        // char[] x = {
        //     'A','T','T','A','C','K','.','T','H',
        //     'E','.','C','A','S','T','L','E','.',
        //     'A','T','.','D','A','W','N', 'A', 'T'};
        // int rows = 3;
        // int cols = 9;
        char[] x = {'T','E',' ','R','T','H','E','S','A','H','A','V','Y','H','I','Q',' ','T','E','T','I',' ','A','C','U','N','T',' ','E','C','I','T','H','I','O','L','G','S','T','S',' ','R',' ','E','R','T','O',' ','W','R','E','B','.','.'};
        for (int i = 0; i < x.length / 2; i++) {
            int end = x.length - i;
            int start = i;
            char temp = x[end];
            x[end] = x[start];
            x[start] = temp;
        }
        int rows = 9;
        int cols = 6;
        // char[] x = {'T','E',' ','R','T','H','E','S','A','H','A','V','Y','H','I','Q',' ','T','E','T','I',' ','A','C','U','N','T',' ','E','C','I','T','H','I','O','L','G','S','T','S',' ','R',' ','E','R','T','O', ' ', 'W'};
        int y1 = x.length;
        // int rows = 7;
        // int cols = 7;
        char[][] m = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int y = cols * i + j;
                m[i][j] = x[y];
            }
        }
        int totalRows = m.length;
        int totalCols = m[0].length;
        int i = rows - 1;
        int j = cols - 1;

        char[] z = new char[x.length];
        int zIndex = 0;
        z[zIndex++] = m[i][j];

        while (zIndex < x.length - 1) {
            if (i == totalRows - 1 && j == totalCols - 1) {
                i--;
                z[zIndex++] = m[i][j];
                // diagonally down
                while (i < totalRows - 1 && j > 0) {
                    i++;
                    j--;
                    if (j >= 0 && i >= 0)
                        z[zIndex++] = m[i][j];
                }
            } else if (j == totalCols - 1 && i > 0) {
                i--;
                z[zIndex++] = m[i][j];
                // diagonally down
                while (i < totalRows - 1 && j > 0) {
                    // if (j - 1 >= 0) {
                    i++;
                    j--;
                    // }
                    if (j >= 0 && i >= 0)
                        z[zIndex++] = m[i][j];
                }
            } else if (i == totalRows - 1 && j > 0) {
                j--;
                z[zIndex++] = m[i][j];
                // diagonally up
                while (j < totalCols - 1 && i > 0) {
                    i--;
                    j++;
                    if (j >= 0 && i >= 0)
                        z[zIndex++] = m[i][j];
                }
            } else if (i == 0 && j > 0) {
                j--;
                z[zIndex++] = m[i][j];
                // diagonally down
                while (i < totalRows - 1) {
                    i++;
                    j--;
                    if (j >= 0 && i >= 0)
                        z[zIndex++] = m[i][j];
                }
            } else if (j == 0 && i > 0) {
            // } else {
                i--;
                z[zIndex++] = m[i][j];
                // diagonally up
                while (j < totalCols - 1 && i > 0) {
                    i--;
                    j++;
                    if (j >= 0 && i >= 0)
                        z[zIndex++] = m[i][j];
                }
            }
            // if (j < 0) {
            //     j = 0;
            // }
            // if (i < 0) {
            //     i = 0;
            // }
            System.out.println(zIndex);
        }
        z[zIndex] = m[0][0];
        System.out.println(z);
        System.out.println(m);
        // while (rows > 1 || cols > 1) {
        // # print(rows, cols);
        // if (rows == totalRows && (cols == totalCols || rows > 1)) {
        // # go up and then move diagonally down.
        // # go up.
        // rows = rows - 1;
        // ciphertext999 <- c(ciphertext999, matrix1[rows, cols]);
        // # go diagonally down.
        // while (rows < totalRows) {
        // rows = rows + 1;
        // cols = cols - 1;
        // ciphertext999 <- c(ciphertext999, matrix1[rows, cols]);
        // }
        // } else if (rows == totalRows && cols > 1) {
        // # go to left cell and then move diagonally up.
        // # go left
        // cols = cols - 1;
        // ciphertext999 <- c(ciphertext999, matrix1[rows, cols]);
        // # go diagonally up.
        // while (cols < totalCols) {
        // rows = rows - 1;
        // cols = cols + 1;
        // ciphertext999 <- c(ciphertext999, matrix1[rows, cols]);
        // }
        // } else if (rows == 1 && cols > 1) {
        // # go to left cell and then move diagonally down.
        // cols = cols - 1;
        // ciphertext999 <- c(ciphertext999, matrix1[rows, cols]);
        // # go diagonally down.
        // while (rows < totalRows) {
        // rows = rows + 1;
        // cols = cols - 1;
        // ciphertext999 <- c(ciphertext999, matrix1[rows, cols]);
        // }
        // } else if (cols == 1 && rows > 1) {
        // # go to upper cell and then move diagonally up.
        // rows = rows - 1;
        // ciphertext999 <- c(ciphertext999, matrix1[rows, cols]);
        // # go diagonally up.
        // while (cols < totalCols) {
        // rows = rows - 1;
        // cols = cols + 1;
        // ciphertext999 <- c(ciphertext999, matrix1[rows, cols]);
        // }
        // }
        // }

        // ciphertext999
    }
}