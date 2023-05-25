public class L2List extends L1List{
    private final static int DEFSIZE = 16;
    private int[] prev;
    public L2List(int capacity) {
        super(capacity);
        prev = new int[capacity + 2];
    }
    public L2List(){
        this(DEFSIZE);
    }

    //Связать два элемента, заданные индексами.
    protected void link(int first, int second) {
        next[first] = second;
        prev[second] = first;
    }

    //Передвинуть указатель в конец списка.
    public void toBack(){
        after = nilList;
        before = prev[nilList];
        after = next[nilList];
    }

    //Указатель в начале списка?
    public boolean begin() {
        return before == nilList;
    }

    //Передвинуть указатель назад.
    public void backward() throws Exception{
        if (before == nilList)
            throw new Exception();
        after = before;
        before = prev[before];
        after = next[after];
    }

    //Получить число перед указателем.
    public int before() throws Exception {
        return array[before];
    }

    // Добавить число перед указателем.
    public void insertFront(int val) throws Exception {
        int index = mallocIndex();
        link(after, index);
        link(index, before);
        before = index;
        array[index] = val;
    }

    //Добавить число за указателем.
    public void insertBack(int val) throws Exception {
        insert(val);
    }

    // Удалить число перед указателем.
    public int eraseFront() throws Exception {
        int val = array[before];
        int index = before;
        before = prev[index];
        link(after, before);
        freeIndex(index);
        return array[before];
    }

}