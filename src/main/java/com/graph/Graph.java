package com.graph;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 图的实现
 * @author Taoweidong
 */
public class Graph {

	/**
	 * 存储顶点
	 */
	private ArrayList<String> vertexList;

	/**
	 * 存储图对应的邻接矩阵
	 */
	private int[][] edges;

	/**
	 * 表示边的数目
	 */
	private int numOfEdges;

	public Graph(int n) {
		//初始化矩阵
		edges = new int[n][n];
		vertexList = new ArrayList<>(n);
		numOfEdges = 0;
	}

	/**
	 * 新增一个节点
	 * @param vertex 节点
	 */
	public void insertVertex(String vertex) {

		vertexList.add(vertex);
	}

	/**
	 * 添加边
	 * @param v1     表示第一个顶点对应的下标
	 * @param v2     表示第二个顶点对应的下标
	 * @param weight 表示矩阵中的值
	 */
	public void insertEdge(int v1, int v2, int weight) {

		edges[v1][v2] = weight;
		edges[v2][v1] = weight;
		numOfEdges++;
	}

	//图中常用的方法

	/**
	 * 返回节点的个数
	 * @return
	 */
	public int getNumOfVertex() {

		return vertexList.size();
	}

	/**
	 * 返回节点i对应的顶点值
	 * @param i 节点
	 * @return 定点值
	 */
	public String getValueByIndex(int i) {

		return vertexList.get(i);
	}

	/**
	 * 显示图对应的矩阵
	 */
	public void showGraph() {

		for (int[] item : edges) {
			System.out.println(Arrays.toString(item));
		}
	}

	public static void main(String[] args) {
		//节点的个数
		int n = 5;
		String[] vertexValues = { "A", "B", "C", "D", "E" };
		//创建图对象
		Graph graph = new Graph(n);
		//循环添加顶点
		for (String item : vertexValues) {
			graph.insertVertex(item);
		}
		//添加边
		graph.insertEdge(0, 1, 1);
		graph.insertEdge(0, 2, 1);
		graph.insertEdge(1, 2, 1);
		graph.insertEdge(1, 3, 1);
		graph.insertEdge(1, 4, 1);

		graph.showGraph();

	}
}
