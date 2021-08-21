#include<bits/stdc++.h>
using namespace std;

int main()
{
	int tt;
	cin>>tt;
	for(int ii=1;ii<=tt;ii++)
	{
		set<double> s1;

		int n;
		cin>>n;
        int i,j;
		int arr[n][2];

		for(i=0;i<n;i++)
		{
			cin>>arr[i][0]>>arr[i][1];
		}
		double k,x;
		for(i=0;i<n;i++)
		{
			if(arr[i][1]<50000)
			{
				k=50000-arr[i][1];
				x=arr[i][0]-2*k;
				s1.insert(x);
			}
			else
			{
				k=(arr[i][1]-50000)/(double)2;
				x=arr[i][0]-k;
				s1.insert(x);
			}
		}
		cout<<"#"<<ii<<" "<<s1.size()<<endl;
	}
}
