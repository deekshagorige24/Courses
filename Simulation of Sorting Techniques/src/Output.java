/**
 *
 * @author sumitha & Deeksha
 *
 */
public class Output{
    public static int SIZE = 0;
    public static Data[] data;
    int index = 0;
    public void Add(Data d){
        if(index<SIZE){
            data[index] = d;
        }
        index++;
    }
    @Override
    public String toString() {
      StringBuilder builder = new StringBuilder();
      builder.append("[");
      for(int i=0; i<SIZE; i++){
          if(data[i] != null){
              builder.append(data[i].toString());
          }
          if(i+1 < SIZE && data[i+1]!= null)
              builder.append(",");
      }
      builder.append("]");
      return builder.toString();
    }
}
