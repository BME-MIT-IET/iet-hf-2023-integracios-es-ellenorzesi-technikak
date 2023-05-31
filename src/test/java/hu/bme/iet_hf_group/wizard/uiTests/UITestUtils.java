package hu.bme.iet_hf_group.wizard.uiTests;

import graphics.GameFrame;
import org.assertj.swing.core.GenericTypeMatcher;
import org.assertj.swing.core.matcher.FrameMatcher;
import org.assertj.swing.core.matcher.JButtonMatcher;
import org.assertj.swing.core.matcher.JLabelMatcher;
import org.assertj.swing.core.matcher.JTextComponentMatcher;
import org.assertj.swing.fixture.*;

import javax.swing.*;
import java.awt.*;

import static org.assertj.swing.finder.WindowFinder.findFrame;

public class UITestUtils {
    private final FrameFixture window;

    public UITestUtils(FrameFixture window) {
        this.window = window;
    }

    public JButtonFixture getButtonFixtureByText(String text) {
        return window.button(JButtonMatcher.withText(text));
    }

    public JTextComponentFixture getTextComponentByText(String text) {
        return window.textBox(JTextComponentMatcher.withText(text));
    }

    public JComboBoxFixture getComboBoxByName(String name) {
        return window.comboBox(name);
    }

    public JLabelFixture getLabelByText(String text) {
        return window.label(JLabelMatcher.withText(text));
    }

    public FrameFixture getFrameByTitle(String title) {
        return findFrame(FrameMatcher.withTitle(title)).using(window.robot());
    }
}
