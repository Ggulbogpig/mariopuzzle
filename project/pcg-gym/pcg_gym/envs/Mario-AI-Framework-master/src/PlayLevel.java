

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import engine.core.MarioGame;
import engine.core.MarioResult;

public class PlayLevel {
    public static void printResults(MarioResult result) {
        System.out.println("****************************************************************");
        System.out.println("Game Status: " + result.getGameStatus().toString() +
                " Percentage Completion: " + result.getCompletionPercentage());
        System.out.println("Lives: " + result.getCurrentLives() + " Coins: " + result.getCurrentCoins() +
                " Remaining Time: " + (int) Math.ceil(result.getRemainingTime() / 1000f));
        System.out.println("Mario State: " + result.getMarioMode() +
                " (Mushrooms: " + result.getNumCollectedMushrooms() + " Fire Flowers: " + result.getNumCollectedFireflower() + ")");
        System.out.println("Total Kills: " + result.getKillsTotal() + " (Stomps: " + result.getKillsByStomp() +
                " Fireballs: " + result.getKillsByFire() + " Shells: " + result.getKillsByShell() +
                " Falls: " + result.getKillsByFall() + ")");
        System.out.println("Bricks: " + result.getNumDestroyedBricks() + " Jumps: " + result.getNumJumps() +
                " Max X Jump: " + result.getMaxXJump() + " Max Air Time: " + result.getMaxJumpAirTime());
        System.out.println("****************************************************************");
    }

    public static String getLevel(String filepath) {
        String content = "";
        try {
            content = new String(Files.readAllBytes(Paths.get(filepath)));
        } catch (IOException e) {
        }
        return content;
    }

    public static void main(String[] args) {
        MarioGame game = new MarioGame();
        new agents.robinBaumgarten.Agent();
        int cnt = 0;

        // MarioResult result = game.runGame(new agents.robinBaumgarten.Agent(), getLevel("C:/Users/hbsss/OneDrive/Documents/게임캡스톤디자인/MarioPuzzle/mariopuzzle/project/pcg-gym/pcg_gym/envs/Mario-AI-Framework-master/levels/GAN/"+String.valueOf(0)+".txt"), 20, 0, true);
        //              System.out.println("Level"+1);
        //              printResults(result);
        // // //            if (result.getCompletionPercentage()<1.0){
        // // //                System.out.printf("%d: %f\n",i,result.getCompletionPercentage());
        // // //            }


        for(int i=1; i<6; i++){
            MarioResult result = game.runGame(new agents.robinBaumgarten.Agent(), getLevel("C:\\Users\\hbsss\\OneDrive\\Documents\\게임캡스톤디자인\\MarioPuzzle\\mariopuzzle\\project\\pcg-gym\\pcg_gym\\envs\\Mario-AI-Framework-master\\levels\\GAN\\lvl-"+String.valueOf(i)+".txt"), 20, 0, true);
            System.out.println("Level"+i);
            printResults(result);
//            if (result.getCompletionPercentage()<1.0){
//                System.out.printf("%d: %f\n",i,result.getCompletionPercentage());
//            }

//         }
        //printResults(game.playGame(getLevel("../levels/original/lvl-1.txt"), 200, 0));
       // printResults(game.runGame(new agents.robinBaumgarten.Agent(), getLevel("./levels/GAN/1.txt"), 20, 0, true));
    }
} }
