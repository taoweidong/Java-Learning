#!/usr/bin/env python3
# -*- coding: utf-8 -*-

import itertools

# 查找算式最小值：对于给定的10个整数，从中任意选出3个，代入算式X+XY-Y+Z,要求求出算式最小值
# 考察点，字符串的递归排序
if __name__ == '__main__':
    # arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    arr = [1, 1, 3, 1, 1, 1, 1, 1, 1, 1]
    # 在给定数组arr中获取count个数的所有排列组合
    list2 = list(itertools.combinations(arr, 3))
    # 设置默认值
    minValue = arr[0] + arr[0] * arr[1] - arr[1] + arr[2]
    for item in list2:
        # 给定一个字符串数组，求字符串数组中所有字符串的全排列组合结果
        tempList = list(itertools.permutations(item, 3))
        # print(tempList)
        for item2 in tempList:
            # 计算值，看是否为最小值，如果值最小，则保存最小结果
            # 指定的数组中随机抽取三个数，然后带入公式:X+XY-Y+Z中，
            tempResult = item2[0] + item2[0] * item2[1] - item2[1] + item2[2]
            minValue = min(minValue, tempResult)

    print(minValue)
