import matplotlib.pyplot as plt
import re
import argparse
import json

#This file parses the json format given by the main sorting algorithm.
#Example json format:
#{
#"algorithm": "MergeSort",
#"dataSetName": "Consumer_Complaints.csv",
#"numberOfData": "10000",
#"executionTimeInMilliseconds": "5",
#"invCount": "48025137",
#"memoryUsageInBytes": "2751195"
#}
def main():
    parser = argparse.ArgumentParser(description='Plot timing data')
    parser.add_argument('file')  #file name where the json output is stored
    parser.add_argument('xaxis') #the x axis for plotting (input size or inv_count)
    parser.add_argument('data_type') #input data type (normal,exponential etc)
    parser.add_argument('result_type') #this the plotted on the y-axis (emoryUsageInBytes,executionTimeInMilliseconds)
    args = parser.parse_args()
    fp = open(args.file)
    x_axis = []
    y_axis_bubble = []
    y_axis_selection = []
    y_axis_insertion = []
    y_axis_merge = []
    y_axis_quick = []
    fp = open(args.file)
    data = json.load(fp)
    for item in data:  #this iterates over a list of JSON objects
        if (int(item[args.xaxis]) not in x_axis) and item['dataSetName'] == args.data_type:
            x_axis.append(int(item[args.xaxis]))
        if item['algorithm'] == "BubbleSort" and item['dataSetName'] == args.data_type:
            y_axis_bubble.append(float(item[args.result_type]))
        if item['algorithm'] == "InsertionSort" and item['dataSetName'] == args.data_type:
            y_axis_insertion.append(float(item[args.result_type]))
        if item['algorithm'] == "SelectionSort" and item['dataSetName'] == args.data_type:
            y_axis_selection.append(float(item[args.result_type]))
        if item['algorithm'] == "MergeSort" and item['dataSetName'] == args.data_type:
            y_axis_merge.append(float(item[args.result_type]))
        if item['algorithm'] == "QuickSort" and item['dataSetName'] == args.data_type:
            y_axis_quick.append(float(item[args.result_type]))

    print(x_axis)
    print (len(x_axis))
    print (len(y_axis_insertion))
    plt.plot(x_axis, y_axis_bubble,label = "Bubble_sort")
    plt.plot(x_axis, y_axis_selection,label = "Selection_sort")
    plt.plot(x_axis, y_axis_insertion,label = "Insertion_sort")
    plt.plot(x_axis, y_axis_merge,label = "Merge_sort")
    plt.plot(x_axis, y_axis_quick,label = "Quick_sort")
    plt.legend(loc='upper left')
    plt.xlabel(args.xaxis)
    # naming the y axis
    plt.ylabel(args.result_type)
    # giving a title to my graph
    plt.title(args.data_type[:-4])
    # function to show the plot
    max_yaxis = []
    max_yaxis.append(max(y_axis_bubble))
    max_yaxis.append(max(y_axis_insertion))
    max_yaxis.append(max(y_axis_selection))
    max_yaxis.append(max(y_axis_merge))
    max_yaxis.append(max(y_axis_quick))
    plt.axis([0,max(x_axis),-2000,max(max_yaxis)]) #moving the y-axis slightly above to see the plots of quick and merge sort
    plt.show()

if __name__ == '__main__':
    main()
