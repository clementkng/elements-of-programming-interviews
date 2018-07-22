import java.util.List;

public class DeleteDuplicates {

    /*
    6.5
    */

    public static int deleteDuplicates(List<Integer> A) {
        int writeIndex = 1;
        for (int i = 1; i < A.size(); i++) {
            if (!A.get(i).equals(A.get(writeIndex-1))) {
                A.set(writeIndex++,A.get(i));
            }
        }
        for (int i = writeIndex; i < A.size(); i++) {
            A.set(i, null);
        }
        return writeIndex;
    }
}
