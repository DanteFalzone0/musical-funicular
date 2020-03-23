package mfun;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

import javax.swing.JPanel;

public class Window extends JPanel {

    private HexTile[][] hexTiles;

    public Window(HexTile[][] hexTiles) {
        this.hexTiles = hexTiles;
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        for (HexTile[] row : this.hexTiles) {
            for (HexTile hexTile : row) {
                this.drawHexTile(g2d, hexTile);
            }
        }
    }

    public void drawHexTile(
        Graphics2D g2d,
        HexTile hexTile
    ) {
        int x = hexTile.getXPos();
        int y = hexTile.getYPos();

        if (hexTile instanceof OceanTile) {
            g2d.setColor(Color.blue);
        }

        g2d.drawLine(x+1, y+1, x+11, y+1);
        g2d.drawLine(x+1, y+1, x-5, y+12);
        g2d.drawLine(x+11, y+1, x+17, y+12);
        g2d.drawLine(x-5, y+12, x+1, y+23);
        g2d.drawLine(x+1, y+23, x+11, y+23);
        g2d.drawLine(x+11, y+23, x+17, y+12);

        g2d.setColor(Color.black);
    }

}