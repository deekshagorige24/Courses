from random import gauss
import random
import time
import numpy as np
import matplotlib.pyplot as plt
import matplotlib.animation as animation


def bubblesort(array):

    for i in range(len(array) - 1):
    
        for j in range(len(array) - 1 - i):
            if array[j] > array[j + 1]:
                temp = array[j]
                array[j] = array[j+1]
                array[j+1] = temp
            yield array

def insertionsort(array):

    for i in range(1, len(array)):
        j = i
        while j > 0 and array[j] < array[j - 1]:
            temp = array[j]
            array[j] = array[j-1]
            array[j-1] = temp
            j = j - 1
            yield array

def mergesort(array, left, right):

    if right <= left:
        return
    mid = left + ((right - left + 1) // 2) - 1
    yield from mergesort(array, left, mid)
    yield from mergesort(array, mid + 1, right)
    yield from merge(array, left, mid, right)
    yield array

def merge(array, left, mid, right):

    merged = []
    left_index = left
    right_index = mid + 1

    while left_index <= mid and right_index <= right:
        if array[left_index] < array[right_index]:
            merged.append(array[left_index])
            left_index = left_index + 1
        else:
            merged.append(array[right_index])
            right_index = right_index + 1

    while left_index <= mid:
        merged.append(array[left_index])
        left_index = left_index + 1

    while right_index <= right:
        merged.append(array[right_index])
        right_index = right_index + 1

    for i, j in enumerate(merged):
        array[left + i] = j
        yield array

def quicksort(array, low, high):

    if low >= high:
        return

    pivot = array[high]
    pivot_index = low

    for i in range(low, high):
        if array[i] < pivot:
            temp = array[i]
            array[i] = array[pivot_index]
            array[pivot_index] = temp
            pivot_index = pivot_index + 1
        yield array
    temp = array[high]
    array[high] = array[pivot_index]
    array[pivot_index] = temp
    yield array

    yield from quicksort(array, low, pivot_index - 1)
    yield from quicksort(array, pivot_index + 1, high)

def selectionsort(array):
    if len(array) == 1:
        return

    for i in range(len(array)):
   
        min = array[i]
        min_index = i
        for j in range(i, len(array)):
            if array[j] < min:
                min = array[j]
                min_index = j
            yield array
        temp = array[i]
        array[i] = array[min_index]
        array[min_index] = temp
   
        yield array

if __name__ == "__main__":
    # Get user input for how many numbers are to be sorted
    number = int(input("Enter number of integers: "))
    selection = "Enter any sorting method:\n(1)bubble\n(2)insertion\n(3)merge\n(4)quick\n(5)selection\n"
    distribution = ['uniform', 'random']
    for n in range(1,6):
        array = [[],[]]
        for i in range(number):
          
            uniform_value = np.random.uniform(0, 50)
            random_value = random.randint(0,number)
          
            array[0].append(uniform_value)
            array[1].append(random_value)

        # Get appropriate selection to supply to matplotlib FuncAnimation method.

        for i in range(len(array)):
            if n == 1:
                option = "Bubble sort"
                result = bubblesort(array[i])
            elif n == 2:
                option = "Insertion sort"
                result = insertionsort(array[i])
            elif n == 3:
                option = "Merge sort"
                result = mergesort(array[i], 0, number - 1)
            elif n == 4:
                option = "Quicksort"
                result = quicksort(array[i], 0, number - 1)
            else:
                option = "Selection sort"
                result = selectionsort(array[i])
                
            # Initialize figure and axis.
            figure , axis  = plt.subplots()
        
            plt.title(option + '(' + distribution[i] + ')')
            # Initialize a bar plot.
            rectangles = plt.bar(range(len(array[i])), array[i], align="edge")
                
            # Set axis limits. 
            axis.set_xlim(0, number)
            axis.set_ylim(0, max(array[i]))

            # count the number of operations
            text = axis.text(0.02, 0.9, "",transform=axis.transAxes)
        
            iter_count = [0]
            def fig(array, rect, iter_count):
                for i,j in zip(rect, array):
                    i.set_height(j)
                iter_count[0] = iter_count[0] + 1
                text.set_text("Number of operations: {}".format(iter_count[0]))

            animate = animation.FuncAnimation(figure, func=fig,fargs=(rectangles, iter_count), frames=result, interval=1,repeat=False)
            plt.show()
            #plt.pause(5)
            #plt.close()

