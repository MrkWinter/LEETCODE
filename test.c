#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<math.h>
#include<string.h>
#include<stdlib.h>
#include<ctype.h>
//594. ���г������
//int findLHS(int* nums, int numsSize) {
//	int max = 0;
//	int i, j;
//	for (i = 0; i < numsSize; i++)//����ÿ��Ԫ��
//	{
//		int temp = 0;
//		int count = 0;
//		for (j = 0; j < numsSize; j++)
//		{
//			if (nums[i] == nums[j] - 1 || nums[i] == nums[j])//ͳ�ƶ���ÿ��Ԫ������������Ȼ����1���ж���
//			{
//				if (nums[i] == nums[j])
//					temp++;
//				count++;
//			}
//		}			
//		if (temp == count)//�ж���Щ���Ƿ����
//				count = 0;
//		if (count > max)//��ÿ��Ԫ�ص�����������Ȼ����1���������Ŀͳ�Ƴ�����������Щ��������ͬ
//			max = count;
//	}
//	return max;
//}//Ч�ʵ�

//int Cmp(const void *a, const void *b)
//{
//	return *(int*)a - *(int*)b;
//}
//
//int findLHS(int* nums, int numsSize) {       // ö�� + ˫ָ�� //�д��󣡣���
//	qsort(nums, numsSize, sizeof(nums[0]), Cmp);
//	int ret = 0;
//	int begin = 0;
//	for (int end = 0; end < numsSize; end++) {
//		if (nums[end] - nums[begin] > 1) {  // ����ֵ����1������ָ�������ƣ���С���߲�ֵ
//			begin++;
//		}
//		if (nums[end] - nums[begin] == 1) { // ��ֵΪ1�����㳤�Ȳ�ȡ��ֵ
//			ret = fmax(ret, end - begin + 1);
//		}
//	}
//	return ret;
//}

//int cmp(const void *e1, const void *e2)//�Զ���ȽϺ���
//{
//	return *(int*)e1 - *(int*)e2;
//}
//int findLHS(int* nums, int numsSize)
//{	
//	int s0 = 0;  //ÿ�μ����г�����г��ȵ���ʼ�±�
//	int s1 = 0;  //ÿ�μ����г�����г��ȵ������±�
//	int start = 0;//��¼ÿ�μ����г�����г��ȵ���ʼ�±�
//	int max =0 ; //ͳ���ҵ�������г�����г���
//	qsort(nums, numsSize, 4, cmp);//����������������� �Ƚ����׼���
//	while (s1 < numsSize - 1)//s1ΪnumsSize-1ʱΪ����������±� ����ѭ��
//	{
//		s0 = start;
//		s1 = start;
//		while (nums[s0] == nums[s1] && s1 < numsSize - 1)//�ҵ�����ʼ�±�Ԫ�ز�ͬ��Ԫ���±� ��¼�±�����´μ���
//			s1++;
//		start = s1;
//		while (nums[s0] == nums[s1] - 1 && s1 < numsSize - 1)//ѭ���������±�Ϊs0��s1֮���Ԫ�ظ���Ϊһ����г�����еĸ���
//			s1++;
//		if (nums[s1] - nums[s0] > 1)//Լ�����ʹ�±�Ϊs1��Ԫ�ظպ�Ϊһ����г�����е����һ��Ԫ��
//			s1--;
//		if (nums[s0] == nums[s1]-1)
//			max = fmax(max, s1 - s0 + 1);//�ú����ó���ĺ�г�����еĸ���
//	}
//	return max;
//}
//int main()
//{                                            //0111111
//	int numb[] = {0,1,1,1,1};          //1,3,5,7,
//	int sz = sizeof(numb) / sizeof(numb[0]); //1,3,2,2,5,2,3,7
//	printf("%d", findLHS(numb,sz));          //1 2 2 2 3 3 5 7       
//	return 0;                                //1,3,2,2,5,2,3,7]
//}
//
//
//int cmp(const void *e1, const void *e2)
//{
//	return *(int*)e1 - *(int*)e2;
//}
//int findLHS(int* nums, int numsSize)
//{
//	int s0 = 0;
//	int s1 = 0;
//	int start = 0;
//	int max = 0;
//	qsort(nums, numsSize, 4, cmp);
//	while (s1 < numsSize - 1)
//	{
//		s0 = start;
//		s1 = start;
//		while (nums[s0] == nums[s1] && s1 < numsSize - 1)
//			s1++;
//		start = s1;
//		while (nums[s0] == nums[s1] - 1 && s1 < numsSize - 1)
//			s1++;
//		if (nums[s1] - nums[s0] > 1)
//			s1--;
//		if (nums[s0] == nums[s1] - 1)
//			max = fmax(max, s1 - s0 + 1);
//	}
//	return max;
//}
//461. ��������
//int hammingDistance(int x, int y)
//{
//	int count = 0;
//	int z = x ^ y;
//	while(z)
//	{
//		z = z & z - 1;
//		count++;
//	}
//	return count;
//}
//int main()
//{
//	int x = 1;
//	int y = 3;
//	printf("%d", hammingDistance(x, y));
//}
//1417. ���¸�ʽ���ַ���
char * reformat(char * s) 
{
	int i = 0;
	int j = 0;
	int count = 0;
	int c = strlen(s);
	for (i = 0; s[i]; i++)
	{
		if (isdigit(s[i]))
		{
			count++;
		}
	}
	if (count * 2 - c == 1 || count * 2 - c == 0)
	{
		for (i = 1; i<=c; i += 2)
		{
			if (isdigit(s[i]))
			{
				for (j = j; j <= c; j += 2)
				{
					if (islower(s[j]))
					{
						char temp = s[j];
						s[j] = s[i];
						s[i] = temp;
						break;
					}
				}
			}
		}
		return s;
	}
	else if (count * 2 - c == -1)
	{

		for (i = 1; i <= c; i += 2)
		{
			if (islower(s[i]))
			{
				for (j = j; j <= c; j += 2)
				{
					if (isdigit(s[j]))
					{
						char temp = s[j];
						s[j] = s[i];
						s[i] = temp;
						break;
					}
				}
			}
		}
		return s;
	}
	else
		return "\0";
}
int main()
{
	char s[10] = "a0b1c2";
	reformat(s);
	printf("%s", s);
	return 0;
}