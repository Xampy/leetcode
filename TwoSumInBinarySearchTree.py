# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def findTarget(self, root: Optional[TreeNode], k: int) -> bool:
        found = False
        search = True
        
        container = list()
        container.append(root)
        while search and container:
            current_el = container.pop(0)
            reminder =  k - current_el.val
            
            node = root
            while node:
                if node.val == reminder and node != current_el:
                    search = False
                    found = True
                    break
                elif reminder < node.val:
                    node = node.left
                else:
                    node = node.right
            if current_el.left != None:
                container.append(current_el.left)
            if current_el.right != None:
                container.append(current_el.right)
                
        return found
        
