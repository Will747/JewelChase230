package JewelChaseTests;

import com.example.jewelchase230.profiles.HighScoreTable;
import com.example.jewelchase230.profiles.Profile;
import org.junit.jupiter.api.Test;


public class HighScoreTableTests {
    @Test
    public void readAndSaveTest() {
        Profile testProfile = new Profile(1, "?", "Test", -1);

        HighScoreTable highScoreTable = HighScoreTable.read();

        highScoreTable.addScore(0, testProfile, 5);
        highScoreTable.save();

        HighScoreTable highScoreTable1 = HighScoreTable.read();
        assert(highScoreTable1.getLevelHighScores(0).getLevelScoreList().size() > 0);
    }
}
