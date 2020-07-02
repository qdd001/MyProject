import java.util.ArrayList;
import java.util.List;

public class ListUtils {

    /**
     * Average divide a List into serveral Lists.
     *
     * @param source
     * @param n
     * @param <T>
     * @return
     */
    public static <T> List<List<T>> averageDistribution(List<T> source, int n) {
        List<List<T>> resultList = new ArrayList<>(n);
        int extraDataSize = source.size() % n;//get extraData and evenly distributed to the front groups.
        int groupSize = source.size() / n;//get size of every group.
        int offset = 0;
        for (int i = 0; i < n; i++) {
            List<T> group;
            if (extraDataSize > 0) {
                group = source.subList(i * groupSize + offset, (i + 1) * groupSize + offset + 1);
                offset++;
                extraDataSize--;
            } else {
                group = source.subList(i * groupSize + offset, (i + 1) * groupSize + offset);
            }
            resultList.add(group);
        }
        return resultList;
    }

    public static void main(String[] args) {
        
    }
}
