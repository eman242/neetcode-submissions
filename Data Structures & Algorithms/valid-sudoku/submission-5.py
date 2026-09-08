class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:

        for i in range(len(board)):
            row = board[i]
            if (self.isValidRow(row)==False):
                return False
            column =[]
            column.append(board[0][i])
            column.append(board[1][i])
            column.append(board[2][i])
            column.append(board[3][i])
            column.append(board[4][i])
            column.append(board[5][i])
            column.append(board[6][i])
            column.append(board[7][i])
            column.append(board[8][i])
    
            if (self.isValidRow(column)==False):
                return False

            for i in range(0,7,3):
                for j in range(0,7,3):
                    sub_board=[]
                    sub_board.extend(board[i][j:j+3])
                    sub_board.extend(board[i+1][j:j+3])
                    sub_board.extend(board[i+2][j:j+3])

                    if (self.isValidRow(sub_board)==False):
                        return False
                 
        return True




    def isValidRow(self, nums: List[str]) -> bool:
        digits=set()
        for i in range(len(nums)):
            if (nums[i]=="."):
                continue
            n = int(nums[i])
            if n>9 or n<1:
                return False
            if (n in digits):
                return False
            digits.add(n)
        return True

        