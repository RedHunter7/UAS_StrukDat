package binaryTree;

import java.util.Random;

public class Clans {
	// 0 = Sinaga ; 1 = Zinga ; 3 = Berti
	// 4 = Abedil ; 5 = Duan
	private Node root[] = new Node[5];
	private String clanList[] = {
			"sinaga", "zinga", "berti",
			"abedil", "duan"
			};
	
	public Clans() {
		for(Node node : root) {
			node = null;
		}
	}
	
	public void insertMember(String value) {
		Node newMember = new Node(value);
		int clanIndex = -1;
		
		char newMemberInitial = Character.toLowerCase(value.charAt(0));
		for(int i=0; i<clanList.length; i++) {
			char clanInitial = clanList[i].charAt(0);
			if(newMemberInitial == clanInitial) {
				clanIndex = i;
			}
		}
		
		if (clanIndex == -1) {
			System.out.println("Pengikut tidak diterima");
			return;
		}
		
		if (root[clanIndex] == null) {
			root[clanIndex] = newMember;
			return;
		}
		
		Node current = root[clanIndex];
		Node parent = current;
		boolean isLeft;
		
		if (value.length() % 2 == 0) {
			current = current.leftChild;
			isLeft = true;
		} else {
			current = current.rightChild;
			isLeft = false;
		}
		
		if (current == null && isLeft) {
			parent.leftChild = newMember;
			return;
		}
		
		if (current == null && !isLeft) {
			parent.rightChild = newMember;
			return;
		}
		
		while (true) {
			parent = current;
			
			if (parent.leftChild == null) {
				parent.leftChild = newMember;
				return;
			}
			
			if (parent.rightChild == null) {
				parent.rightChild = newMember;
				return;
			}
			
			Random random = new Random();
			isLeft = random.nextBoolean();
			
			if (isLeft) current = current.leftChild;
			else current = current.rightChild;
		}
	}
	
	private int maxDepth(Node node) {
		int leftDepth, rightDepth;
		leftDepth = rightDepth = -2;
		
		if (node != null) {
			leftDepth = maxDepth(node.leftChild); 
		    rightDepth = maxDepth(node.rightChild); 
		}

	    if (leftDepth > rightDepth) {
	    	return (leftDepth + 1); 
	    } else {
	    	return (rightDepth + 1); 
	    }
	}
	
	private Integer findClan(String value) {
		int clanIndex = -1;
		for(int i=0; i<clanList.length; i++) {
			if(clanList[i] == value) {
				clanIndex = i;
				break;
			}
		}
		
		if (clanIndex == -1) {
			System.out.println("Nama Klan tidak ditemukan");
			return null;
		}
		
		return clanIndex;
	}
	
	public Integer getLevel(String value) {
		return maxDepth(root[findClan(value)]);
	}
	
	private int totalMember(Node node) {
		if (node == null) return 0;
		int leftTotal = totalMember(node.leftChild);
		int rightTotal = totalMember(node.rightChild);
		
		return 1 + leftTotal + rightTotal;
	}
	
	public Integer getMember(String value) {
		return totalMember(root[findClan(value)]);
	}
	
	public void printAllLeaders() {
		System.out.println("Daftar Pemimpin Klan");
		for (int i=0; i<clanList.length; i++) {
			if (root[i] != null) {
				System.out.println(clanList[i] + ": " + root[i].data);
			} else {
				System.out.println(clanList[i] + ": Tidak ada");
			}
		}
	}
}
