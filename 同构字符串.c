#define _CRT_SECURE_NO_WARNINGS 1
#include<stdbool.h>
#include<stdio.h>
#include<stdlib.h>
//给定两个字符串 s 和 t ，判断它们是否是同构的。
//
//如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
//
//每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
//
//
//
//示例 1:
//
//输入：s = "egg", t = "add"
//输出：true
//
//示例 2：
//
//输入：s = "foo", t = "bar"
//输出：false
//
//示例 3：
//
//输入：s = "paper", t = "title"
//输出：true
//205. 同构字符串
bool isIsomorphic(char * s, char * t)
{
	int i = 0;
	int j = 0;
	int s1 = strlen(s);//算出字符串长度
	int t1 = strlen(t);
	char* pt = calloc(t1 + 1, 1);
	strcpy(pt, t);//复制一个临时字符串
	for (i = 0; i <= s1; i++)
	{
		for (j = 0; j < i; j++)
		{
			if (s[j] == s[i])//找到替换的字符
			{
				if (pt[j] != pt[i])
					return false;
				i++;
				j = 0;
			}
		}
		for (j = 0; j <= t1; j++)//将字符替换到t字符串中
		{
			if (pt[j] == pt[i])
			{
				t[j] = s[i];
			}
		}
	}
	free(pt);
	pt = NULL;
	if (strcmp(s, t) == 0)//比较字符串是否相等
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