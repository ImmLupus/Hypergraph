#include <iostream>
#include <locale.h>
#include <fstream>
#include <conio.h>
#include <vector>
#include <conio.h>
using namespace std;

const int otladka = 0;

ofstream log("log.txt");
int n,m,k,count=0,f;
vector<vector<vector<vector<int> > > > Data;
vector<int> M;	//Значения вершин типа I
vector<vector<int>> Res;
vector<int> flag,temp;

struct heap{
	int R,I;
};
vector<vector<heap> > H;	//Вектор по критерием векторов

bool operator == (vector<heap> a, vector<heap> b){
	for (int i=0; i<a.size(); i++){
		if (a[i].R!=b[i].R || a[i].I!=b[i].I) return false;
	}
	return true;
}

void rek(heap h, vector<int> bR, vector<int> bI, vector<heap> tempH){
	vector<heap> tempH1;
	heap h1,h2;
	vector<int> bR1,bI1;
	for (int j=0; j<n; j++){	//R
		if (bR[j]==0){
			bR1=bR;
			bR1[j]=1;
			h1=h;
			h1.R=j;
			for (int q=0; q<m; q++){	//I
				if (bI[q]>0){
					bI1=bI;
					bI1[q]--;
					h2=h1;
					h2.I=q;
					tempH1=tempH;
					tempH1.push_back(h2);
					//cout<<h3.L<<" "<<h3.R<<" "<<h3.I<<endl;
					rek(h,bR1,bI1,tempH1);
				}
			}
		}
	}
	if (tempH.size()==n){
		//H.push_back(tempH);
		for (int j=0; j<k; j++){	//Расчет
			temp[j]=0;
			for (int i=0; i<n; i++){
				temp[j]+=Data[i][tempH[i].R][tempH[i].I][j];
			}
		}
		count++;
		if(count%1000000==0) cout<<count<<endl;
		if (otladka==1){
			log<<count<<")"<<endl;
			for (int j=0; j<n; j++){	//log
				log<<j<<" "<<tempH[j].R<<" "<<tempH[j].I<<" ";
				log<<"| ";
				for (int q=0; q<k; q++) log<<Data[j][tempH[j].R][tempH[j].I][q]<<" ";
				log<<endl;
			}
			log<<"-----"<<endl;
			for (int i=0; i<k; i++) log<<temp[i]<<" ";
			log<<endl<<"====="<<endl;
		}
		if (!Res.empty()){	//Создание списка несравнимых
			for (int i=0; i<Res.size(); i++){
				for (int q=0; q<k; q++) {
					if (Res[i][q]<temp[q]) flag[q]=1;
					if (Res[i][q]==temp[q]) flag[q]=0;
					if (Res[i][q]>temp[q]) flag[q]=-1;
				}
				for (int q=0; q<k; q++) if (flag[q]!=0 && flag[q]!=-1) goto loop1; //Если все равны, на выход
				goto exit;
				loop1:
				for (int q=0; q<k; q++) if (flag[q]!=1 && flag[q]!=0) goto loop2;
				for (int j=0; j<Res.size(); j++){	//Удаление всех кто строго меньше
					for (int q=0; q<k; q++) {
						if (Res[j][q]<temp[q]) flag[q]=1;
						if (Res[j][q]==temp[q]) flag[q]=0;
						if (Res[j][q]>temp[q]) flag[q]=-1;
					}
					for (int q=0; q<k; q++) if (flag[q]!=1 && flag[q]!=0) goto loop3;
					Res.erase(Res.begin()+j);
					H.erase(H.begin()+j);
					loop3:;
				}
				Res.push_back(temp);
				H.push_back(tempH);
				//for (int q=0; q<k; q++) cout<<Res[Res.size()-1][q]<<" "; cout<<">"<<endl; getch();
				goto exit;
				loop2:;
			}
			Res.push_back(temp);
			H.push_back(tempH);
			//for (int q=0; q<k; q++) cout<<Res[Res.size()-1][q]<<" "; cout<<"<>"<<endl; getch();
			exit:;
		}
		else{
			Res.push_back(temp);
			H.push_back(tempH);
			//for (int q=0; q<k; q++) cout<<Res[Res.size()-1][q]<<" "; cout<<endl;
		}
	}
	return;
}

main(){
	ifstream in("input.txt");
	ofstream result("result.txt");
	vector<int> mR,mI;	//Флаги занятости
	in>>k;
	in>>n>>m;
	mR.resize(n);
	mI.resize(m);
	M.resize(m);
	flag.resize(k);
	temp.resize(k);
	for (int i=0; i<m; i++) in>>M[i];
	
	//Выделение памяти для Data
	Data.resize(n);
	for (int i=0; i<n; i++) Data[i].resize(n);
	for (int i=0; i<n; i++) for (int j=0; j<n; j++) Data[i][j].resize(m);
	for (int i=0; i<n; i++) for (int j=0; j<n; j++) for (int q=0; q<m; q++) Data[i][j][q].resize(k);
	
	for (int p=0; p<k; p++){
		for (int i=0; i<n; i++){
			for (int j=0; j<n; j++){
				for (int q=0; q<m; q++){
					in>>Data[i][j][q][p];
				}
			}
		}
	}
	
	vector<heap> tempH;
	for (int i=0; i<n; i++) mR[i]=0;
	for (int i=0; i<m; i++) mI[i]=M[i];
	heap h={-1,-1};
	
	rek(h,mR,mI,tempH);
	
	for (int i=0; i<Res.size(); i++){
		for (int q=0; q<n; q++) cout<<q<<" "<<H[i][q].R<<" "<<H[i][q].I<<endl;
		cout<<"-----"<<endl;
		for (int q=0; q<n; q++) result<<q<<" "<<H[i][q].R<<" "<<H[i][q].I<<endl;
		result<<"-----"<<endl;
		for (int j=0; j<k; j++){
			cout<<Res[i][j]<<" ";
			
			result<<Res[i][j]<<" ";
			
		}
		result<<endl<<"====="<<endl;
		cout<<endl<<"====="<<endl;
	}
	/*for (int i=0; i<H.size()-1; i++){
		for (int j=i+1; j<H.size(); j++){
			if (H[i]==H[j]) cout<<i+1<<" "<<j+1<<endl;
		}
	}*/
	system("pause");
}
