class Unix {
    static int[] output = { 0, 0, 0 };

    static void count(String input[], String string) {
        String temp = string.substring(1);
        int num = Integer.parseInt(temp);
        if (input[num - 1] == "cp") {
            output[0]++;
        } else if (input[num - 1] == "ls") {
            output[1]++;
        } else if (input[num - 1] == "mv") {
            output[2]++;
        } else {
            count(input, input[num-1]);
        }
    }

    public static void main(String[] args) {
        String input[] = new String[] { "ls", "cp", "mv", "mv", "mv", "!1", "!3", "!6" }; // 'ls', 'cp', 'mv', 'mv',
                                                                                          // 'mv', '!1', '!3', '!6'
        for (String string : input) {
            if (string == "cp")
                output[0]++;
            else if (string == "ls")
                output[1]++;
            else if (string == "mv")
                output[2]++;
            else
                count(input, string);
        }
        for (int element: output) {
            System.out.print(element+" ");
        }
    }
}