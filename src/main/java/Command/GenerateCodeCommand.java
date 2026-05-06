package Command;

public class GenerateCodeCommand implements Command {

    private PixelGrid grid;

    public GenerateCodeCommand(PixelGrid grid) {
        this.grid = grid;
    }

    @Override
    public void execute() {

        int[][] g = grid.getGrid();

        System.out.println("int[][] pixelArt = {");

        for (int i = 0; i < g.length; i++) {
            System.out.print("    {");

            for (int j = 0; j < g[i].length; j++) {
                System.out.print(g[i][j]);
                if (j < g[i].length - 1) System.out.print(", ");
            }

            System.out.print("}");

            if (i < g.length - 1) System.out.println(",");
            else System.out.println();
        }

        System.out.println("};");
    }
}
