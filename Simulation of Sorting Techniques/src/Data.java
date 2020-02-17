/**
 * This is a model class to store all the properties and prints out in JSON format.
 * @author sumitha & Deeksha
 *
 */
public class Data {
    String algorithmName;
    String dataSetName;
    int numberOfData;
    long executionTime;
    long memoryUsage;
    long invCount;
    public Data(String algorithmName, String dataSetName, int numberOfData, long executionTime, long memoryUsage, long inv_count) {
        this.algorithmName = algorithmName;
        this.dataSetName = dataSetName;
        this.executionTime = executionTime;
        this.memoryUsage = memoryUsage;
        this.numberOfData = numberOfData;
        this.invCount = inv_count;
    }
    @Override
    public String toString() {
      StringBuilder builder = new StringBuilder();
      builder.append("{\"algorithm\":\"");
      builder.append(algorithmName);
      builder.append("\",");
      builder.append("\"dataSetName\":\"");
      builder.append(dataSetName);
      builder.append("\",");
      builder.append("\"numberOfData\":\"");
      builder.append(numberOfData);
      builder.append("\",");
      builder.append("\"executionTimeInMilliseconds\":\"");
      builder.append(executionTime);
      builder.append("\",");
      builder.append("\"invCount\":\"");
      builder.append(invCount);
      builder.append("\",");
      builder.append("\"memoryUsageInBytes\":\"");
      builder.append(memoryUsage);
      builder.append("\"}");
      return builder.toString();
    }
}
