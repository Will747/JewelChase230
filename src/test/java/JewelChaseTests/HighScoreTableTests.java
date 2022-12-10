package JewelChaseTests;

import com.example.jewelchase230.profiles.HighScoreTable;
import com.example.jewelchase230.profiles.Profile;
import org.junit.jupiter.api.Test;

public class HighScoreTableTests {
    @Test
    public void readAndSaveTest() {
        Profile testProfile = new Profile("Test", 'b');

        HighScoreTable highScoreTable = HighScoreTable.read();

        highScoreTable.addScore(1, testProfile, 5);
        highScoreTable.save();

        HighScoreTable highScoreTable1 = HighScoreTable.read();
        assert(highScoreTable1.getLevelHighScores(1).getScoreList().size() > 0);
    }
}
