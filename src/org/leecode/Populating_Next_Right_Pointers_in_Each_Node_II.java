package org.leecode;

public class Populating_Next_Right_Pointers_in_Each_Node_II {
	//层次递进法 时间 O(N) 空间 O(1)
    //思路: 第一问层次递进的延伸。上一问中我们不需要一个额外的指针来控制我们一层中链接的节点，因为我们知道肯定是左右左右的顺序，
    //而这题中左右节点可能不存在，所有我们要用一个指针记录这一层中我们链接到了哪个节点，方便我们链接下一个节点。
    public void connect(TreeLinkNode root) {
        // head是上一层的节点，我们用上一层节点的next形成链表，来链接当前这层
        TreeLinkNode head = root;
        while(head != null){
            TreeLinkNode dummy = new TreeLinkNode(0);// dummy指向该层的第一节点
            TreeLinkNode pre = dummy;//记录链接到哪个节点的额外指针
            while(head != null){//连接本层所有节点
                if(head.left != null){// 尝试链接左节点
                    pre.next = head.left;
                    pre = pre.next;
                }
                
                if(head.right != null){// 尝试链接右节点
                    pre.next = head.right;
                    pre = pre.next;
                }
                head = head.next;
            }
            
            head = dummy.next;// 将head移动到当前这层的的第一个，准备链接下一层
        }
    }
    
	public void connect1(TreeLinkNode root) {
		TreeLinkNode head = root;
		while (head != null){
			TreeLinkNode dummy = new TreeLinkNode(0);
			TreeLinkNode pre = dummy;
			while (head != null){
				if (head.left != null){
					pre.next = head.left;
					pre = pre.next;
				}
				if (head.right != null){
					pre.next = head.right;
					pre = pre.next;
				}
				head = head.next;
			}
			head = dummy.next;
		}
	}
}
