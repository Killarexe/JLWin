package net.killarexe.jlwin.util.tile;

import net.killarexe.jlwin.file.Image;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TileMap {
    
    private int x, y;
    private int tileSize;
    private int tileWidth, tileHeight;
    private int[][] map;
    private Tile tile;

    public TileMap(String map, int tileSize, int tileWidth, int tileHeight, Tile tile) {
        this.tileSize = tileSize;
        this.tileWidth = tileWidth;
        this.tileHeight = tileHeight;
        this.map = new int[tileHeight][tileWidth];
        this.tile = tile;
        for(int h=0; h<tileHeight; h++){
            String[] tokens = map.split(" ");
            for (int w = 0; w < tileWidth; w++) {
                this.map[h][w] = Integer.parseInt(tokens[w]);
            }
        }
    }

    public void draw(Graphics g){
        for(int i=0; i < tile.getImages().size(); i++){
            for (int j = 0; j < tileWidth; j++) {
                int rc = map[i][j];
                //g.drawImage(tile.getImages().get(rc), x + j * tileSize, y + i * tileSize);
            }
        }
    }
}
