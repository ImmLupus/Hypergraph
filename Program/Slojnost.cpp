#include <iostream>
#include <fstream>
#include <vector>
#include <windows.h>
using namespace std;

int count=0;

int fact(int N)
{
    if(N < 0) // ���� ������������ ���� ������������� �����
        return 0; // ���������� ����
    if (N == 0) // ���� ������������ ���� ����,
        return 1; // ���������� ��������� �� ���� - �� �����������, �� ��� 1 =)
    else // �� ���� ��������� �������
        return N * fact(N - 1); // ������ ��������.
}

void func(vector<int> I, int k, vector<int> D){
	vector<int> tempI; tempI=I;
	vector<int> tempD; tempD=D;
	if (k>0)
	for (int i=0; i<I.size(); i++){
		if (tempI[i]>0){
			tempI[i]--;
			tempD.push_back(i+1);
			func(tempI, k-1, tempD);
			tempI=I; tempD=D;
		}
	}
	else{
		count++;
		return;
	}
	return;
}

main(){
	ifstream in("input.txt");
	vector<int> D;
	int n,m,x;
	vector<int> I;
	in>>n>>n>>m;
	for (int i=0; i<m; i++) {
		in>>x;
		I.push_back(x);
	}
	func(I,n,D);
	//cout<<endl<<count;
	cout<<endl<<fact(n)*count;
	cout<<endl;
	system("pause");
}
