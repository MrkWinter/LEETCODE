#define _CRT_SECURE_NO_WARNINGS 1
#include<stdbool.h>
#include<stdio.h>
#include<stdlib.h>
//���������ַ��� s �� t ���ж������Ƿ���ͬ���ġ�
//
//��� s �е��ַ����԰�ĳ��ӳ���ϵ�滻�õ� t ����ô�������ַ�����ͬ���ġ�
//
//ÿ�����ֵ��ַ���Ӧ��ӳ�䵽��һ���ַ���ͬʱ���ı��ַ���˳�򡣲�ͬ�ַ�����ӳ�䵽ͬһ���ַ��ϣ���ͬ�ַ�ֻ��ӳ�䵽ͬһ���ַ��ϣ��ַ�����ӳ�䵽�Լ�����
//
//
//
//ʾ�� 1:
//
//���룺s = "egg", t = "add"
//�����true
//
//ʾ�� 2��
//
//���룺s = "foo", t = "bar"
//�����false
//
//ʾ�� 3��
//
//���룺s = "paper", t = "title"
//�����true
//205. ͬ���ַ���
bool isIsomorphic(char * s, char * t)
{
	int i = 0;
	int j = 0;
	int s1 = strlen(s);//����ַ�������
	int t1 = strlen(t);
	char* pt = calloc(t1 + 1, 1);
	strcpy(pt, t);//����һ����ʱ�ַ���
	for (i = 0; i <= s1; i++)
	{
		for (j = 0; j < i; j++)
		{
			if (s[j] == s[i])//�ҵ��滻���ַ�
			{
				if (pt[j] != pt[i])
					return false;
				i++;
				j = 0;
			}
		}
		for (j = 0; j <= t1; j++)//���ַ��滻��t�ַ�����
		{
			if (pt[j] == pt[i])
			{
				t[j] = s[i];
			}
		}
	}
	free(pt);
	pt = NULL;
	if (strcmp(s, t) == 0)//�Ƚ��ַ����Ƿ����
		return true;
	else
		return false;
}
int main()
{
	char s[] = "egg";
	char t[] = "add";
	bool a  = isIsomorphic(s, t);
	printf("%d", a);
	return 0;
}