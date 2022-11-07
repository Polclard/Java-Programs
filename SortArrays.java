import java.util.Arrays;

class HelloWorld {

    public static int [] sort(int [] a, int n)
    {

        if(n <= 1)
            return a;

        int [] list1 = new int[n/2];
        int [] list2= new int[n-(n/2)];

        int ct1 = 0;
        int ct2 = 0;

        int i = 0;
        for(; i < n/2; i++)
        {
            list1[ct1] = a[i];
            ct1++;
        }
        for(; i < n; i++)
        {
            list2[ct2] = a[i];
            ct2++;
        }

        list1 = sort(list1, n/2);
        list2 = sort(list2, n-(n/2));

        return merge(list1, list2);
    }

    public static int[] merge(int [] l1, int [] l2)
    {
        int [] finalList = new int[l1.length + l2.length];

        int ct1 = 0, ct2= 0;

        int counter = 0;

        while(ct1 < l1.length && ct2 < l2.length)
        {
            if (l1[ct1] <= l2[ct2]) {
                finalList[counter++] = l1[ct1];
                ct1++;
            }
            else
            {
                finalList[counter++] = l2[ct2];
                ct2++;
            }
        }

        for(int i = ct1; i < l1.length; i++)
        {
            finalList[counter++] = l1[i];
        }
        for(int i = ct2; i < l2.length; i++)
        {
            finalList[counter++] = l2[i];
        }

        return finalList;
    }

    public static void main(String[] args) {

        int [] list = {1,4,3,2,7,10,8,5,6,9};
        //int [] list = {1,3,2,4,5,7};

        System.out.println("Before");
        System.out.println(Arrays.toString(list));
        System.out.println("After");
        int [] newList = sort(list, list.length);
        System.out.println(Arrays.toString(newList));

    }
}
