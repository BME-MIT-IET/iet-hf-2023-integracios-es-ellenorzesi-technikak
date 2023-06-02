package hu.bme.iet_hf_group.wizard.uiTests;

import hu.bme.iet_hf_group.wizard.graphics.GameFrame;
import hu.bme.iet_hf_group.wizard.graphics.MenuFrame;
import org.assertj.swing.core.GenericTypeMatcher;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.junit.testcase.AssertJSwingJUnitTestCase;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

import static org.assertj.swing.finder.WindowFinder.findFrame;

public class MenuFrameTest extends AssertJSwingJUnitTestCase {
    private FrameFixture window;
    private UITestUtils utils;

    @Before
    @Override
    public void onSetUp() {
        var frame = GuiActionRunner.execute(MenuFrame::new);
        window = new FrameFixture(robot(), frame);
        utils = new UITestUtils(window);
        window.show();
    }

    @Test
    public void testWindowTitle(){
        window.requireTitle("Blind Virologists");
    }

    @Test
    public void testButtonNewGame() {
        var newGameButton = utils.getButtonFixtureByText("New Game");
        newGameButton.requireEnabled();
        newGameButton.requireVisible();
        newGameButton.requireText("New Game");
    }

    @Test
    public void testButtonLoadGame() {
        var loadGameButton = utils.getButtonFixtureByText("Load Game");
        loadGameButton.requireEnabled();
        loadGameButton.requireVisible();
        loadGameButton.requireText("Load Game");
    }

    @Test
    public void testLabelTitle(){
        var titleLabel = utils.getLabelByText("Blind Virologists");
        titleLabel.requireVisible();
        titleLabel.requireEnabled();
    }

    @Test
    public void testLabelNumberOfPlayers(){
        var numberOfPlayersLabel = utils.getLabelByText("Number of players: ");
        numberOfPlayersLabel.requireVisible();
        numberOfPlayersLabel.requireEnabled();
    }

    @Test
    public void testTextFieldPlayerCount(){
        var playerCountTextField = utils.getTextComponentByText("2");
        playerCountTextField.requireVisible();
        playerCountTextField.requireEnabled();
        playerCountTextField.requireEditable();
        playerCountTextField.requireText("2");
        playerCountTextField.click();
        playerCountTextField.requireFocused();
        playerCountTextField.robot().pressKey(KeyEvent.VK_BACK_SPACE);
        playerCountTextField.requireText("");
        playerCountTextField.robot().enterText("123");
        playerCountTextField.requireText("123");
    }

    @Test
    public void testButtonClickNewGame() {
        utils.getButtonFixtureByText("New Game").click();
        findFrame(new GenericTypeMatcher<>(Frame.class) {
            protected boolean isMatching(Frame frame) {
                return "Blind Virologists".equals(frame.getTitle()) && frame.isShowing() && frame instanceof GameFrame;
            }
        }).using(robot());
    }

    @Test
    public void testTextFieldPlayerCountOnlyNumericalValueAllowed() {
        var playerCountTextField = utils.getTextComponentByText("2");
        playerCountTextField.click();
        playerCountTextField.robot().enterText("The");
        playerCountTextField.requireText("2");
    }

    @Test
    public void testTextFieldPlayerCountMaxLengthLimited() {
        var playerCountTextField = utils.getTextComponentByText("2");
        playerCountTextField.click();
        playerCountTextField.robot().pressKey(KeyEvent.VK_BACK_SPACE);
        playerCountTextField.robot().enterText("012345678910");
        playerCountTextField.requireText("0123456789");
    }
}
