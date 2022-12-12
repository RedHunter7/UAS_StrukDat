package binaryTree;

import binaryTree.Clans;

public class Main {
	public static void main(String[] args) {
		Clans clans = new Clans();
		clans.insertMember("Singa");
		clans.insertMember("Sobong");
		clans.insertMember("sima");
		clans.insertMember("simala");
		clans.insertMember("Songo");
		clans.insertMember("Singi");
		clans.insertMember("Singo");
		clans.insertMember("Sange");
		System.out.println("level " + clans.getLevel("sinaga"));
		System.out.println("Jumlah anggota " + clans.getMember("sinaga"));
		clans.printAllLeaders();
	}
}
