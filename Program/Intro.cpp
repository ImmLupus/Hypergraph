#include <iostream>
#include <locale.h>
#include <fstream>
#include <conio.h>
using namespace std;
main(){
	setlocale(LC_ALL,"rus");
	ofstream out("input.txt");
	int n,m,i,j,q,s,k,p;
	char ch;
	cout<<"������� ���������� ���������: ";
	cin>>k;
	cout<<"������� ���������� ������ ���� L � R: ";
	cin>>n;
	cout<<"������� ���������� ������ ���� I: ";
	cin>>m;
	int A[n][n][m][k];	//��������� �����
	int B[m];	//�������� ������ ���� I
	cout<<endl<<"�����, ������� ���� �����:"<<endl;
	for (p=0; p<k; p++){
		cout<<"�� �������� ����� "<<p+1<<":"<<endl;
		for (i=0; i<n; i++){
			for (j=0; j<n; j++){
				for (q=0; q<m; q++){
					cout<<"L"<<i<<" "<<"R"<<j<<" "<<"I"<<q<<" ";
					cin>>A[i][j][q][p];
				}
			}
		}
	}
	loop1:
	cout<<endl<<"������� \'n\' ����� ������� � ���������� �����, ��� \'r\' ����� ������������� ������";
	loop:
	ch=getch();
	if (ch=='r'){
		cout<<endl<<endl<<"������� ������ ������ L R I, ����� �������� � ����� ��� ����� ����� (���� ����): ";
		cin>>i>>j>>q>>p>>s;
		A[i][j][q][p-1]=s;
		cout<<endl;
		goto loop1;
	}
	if (ch=='n') {
		cout<<endl<<endl<<"�����, ������� �������� ��� ���� ������ ���� I:"<<endl;
		for (i=0; i<m; i++) {
			cout<<"I["<<i<<"] ";
			cin>>B[i];
		}
		loop21:
		cout<<endl<<"������� \'s\' ����� ��������� ���������, ��� \'r\' ����� ������������� ������";
		loop20:
		ch=getch();
		if (ch=='r'){
			cout<<endl<<endl<<"������� ����� I'��� ������� � ����� ��������: ";
			cin>>i>>s;
			B[i]=s;
			cout<<endl;
			goto loop21;
		}
		if (ch=='s'){
			out<<k<<endl;	//������ ���-�� ���������
			out<<n<<" "<<m<<endl;	//������ ���-�� ������ ���� L R � I
			for (i=0; i<m; i++) out<<B[i]<<" ";	//������ �������� ���� ������ ���� I
			out<<endl;
			for (p=0; p<k; p++) for (i=0; i<n; i++) for (j=0; j<n; j++) for (q=0; q<m; q++) out<<A[i][j][q][p]<<" ";	//������ ����� �����
			return 0;
		}
		goto loop20;
	}
	goto loop;
}
