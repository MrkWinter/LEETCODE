#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<math.h>
#include<string.h>
#include<stdlib.h>
#include<ctype.h>
//594. 最长和谐子序列
//int findLHS(int* nums, int numsSize) {
//	int max = 0;
//	int i, j;
//	for (i = 0; i < numsSize; i++)//遍历每个元素
//	{
//		int temp = 0;
//		int count = 0;
//		for (j = 0; j < numsSize; j++)
//		{
//			if (nums[i] == nums[j] - 1 || nums[i] == nums[j])//统计对于每个元素在数组中相等或大于1数有多少
//			{
//				if (nums[i] == nums[j])
//					temp++;
//				count++;
//			}
//		}			
//		if (temp == count)//判断这些数是否都相等
//				count = 0;
//		if (count > max)//把每个元素的在数组中相等或大于1数的最大数目统计出来，并且这些数不都相同
//			max = count;
//	}
//	return max;
//}//效率低

//int Cmp(const void *a, const void *b)
//{
//	return *(int*)a - *(int*)b;
//}
//
//int findLHS(int* nums, int numsSize) {       // 枚举 + 双指针 //有错误！！！
//	qsort(nums, numsSize, sizeof(nums[0]), Cmp);
//	int ret = 0;
//	int begin = 0;
//	for (int end = 0; end < numsSize; end++) {
//		if (nums[end] - nums[begin] > 1) {  // 若差值大于1，则左指针向右移，缩小二者差值
//			begin++;
//		}
//		if (nums[end] - nums[begin] == 1) { // 差值为1，计算长度并取最值
//			ret = fmax(ret, end - begin + 1);
//		}
//	}
//	return ret;
//}

//int cmp(const void *e1, const void *e2)//自定义比较函数
//{
//	return *(int*)e1 - *(int*)e2;
//}
//int findLHS(int* nums, int numsSize)
//{	
//	int s0 = 0;  //每次计算和谐字序列长度的起始下标
//	int s1 = 0;  //每次计算和谐字序列长度的最终下标
//	int start = 0;//记录每次计算和谐字序列长度的起始下标
//	int max =0 ; //统计找到的最大和谐字序列长度
//	qsort(nums, numsSize, 4, cmp);//对数组进行升序排序 比较容易计算
//	while (s1 < numsSize - 1)//s1为numsSize-1时为最大数数组下标 跳出循环
//	{
//		s0 = start;
//		s1 = start;
//		while (nums[s0] == nums[s1] && s1 < numsSize - 1)//找到和起始下标元素不同的元素下标 记录下标便于下次计算
//			s1++;
//		start = s1;
//		while (nums[s0] == nums[s1] - 1 && s1 < numsSize - 1)//循环结束后下标为s0和s1之间的元素个数为一个和谐子序列的个数
//			s1++;
//		if (nums[s1] - nums[s0] > 1)//约束情况使下标为s1的元素刚好为一个和谐子序列的最后一个元素
//			s1--;
//		if (nums[s0] == nums[s1]-1)
//			max = fmax(max, s1 - s0 + 1);//用函数得出最长的和谐子序列的个数
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
//461. 汉明距离
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
//1417. 重新格式化字符串
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