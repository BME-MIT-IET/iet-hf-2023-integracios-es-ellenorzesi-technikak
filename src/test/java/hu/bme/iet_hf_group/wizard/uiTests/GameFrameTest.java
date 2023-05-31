package hu.bme.iet_hf_group.wizard.uiTests;

import hu.bme.iet_hf_group.wizard.earlyacces_source.Material;
import hu.bme.iet_hf_group.wizard.earlyacces_source.Virologist;
import hu.bme.iet_hf_group.wizard.earlyacces_source.code.*;
import hu.bme.iet_hf_group.wizard.earlyacces_source.field.FreeField;
import hu.bme.iet_hf_group.wizard.earlyacces_source.field.Laboratory;
import hu.bme.iet_hf_group.wizard.earlyacces_source.field.Shelter;
import hu.bme.iet_hf_group.wizard.earlyacces_source.field.Storage;
import hu.bme.iet_hf_group.wizard.earlyacces_source.gameCore.Round_Manager;
import hu.bme.iet_hf_group.wizard.earlyacces_source.gear.Axe;
import hu.bme.iet_hf_group.wizard.earlyacces_source.gear.Bag;
import hu.bme.iet_hf_group.wizard.earlyacces_source.gear.Gear;
import org.assertj.swing.core.GenericTypeMatcher;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.junit.testcase.AssertJSwingJUnitTestCase;
import org.junit.Test;
import javax.swing.*;
import java.util.Arrays;
import java.util.Objects;

public class GameFrameTest extends AssertJSwingJUnitTestCase {
    private FrameFixture window;
    private UITestUtils utils;

    private final Axe axe = new Axe();
    private final Bag bag = new Bag();

    @Test
    public void testButtonSearchField() {
        startFreshWithShelter(axe, new Virologist(), new Virologist());
        var searchButton = utils.getButtonFixtureByText("Search Field");
        searchButton.click();
        assert Objects.equals(Round_Manager.getInstance().getVirologist("v1").getGears().get(0), axe);
    }

    @Test
    public void testComboBoxVirologists() {
        startFresh(new FreeField(), new Virologist(), new Virologist());
        var virologistsComboBox = utils.getComboBoxByName("virologistsComboBox");
        var rm = Round_Manager.getInstance();
        for (var v : rm.getVirologists().values()) {
            assert Arrays.asList(virologistsComboBox.contents()).contains(rm.getVirologistsName(v));
        }
        virologistsComboBox.selectItem("v2");
        virologistsComboBox.requireSelection("v2");
    }

    @Test
    public void testComboBoxCodes() {
        var v1 = new Virologist();
        var codes = new Code[]{new Protection(), new Chorea(), new Oblivion(), new Paralysing()};
        for (Code code : codes) {
            v1.add(code);
        }
        startFresh(new Laboratory(new Protection()), v1, new Virologist());

        var codesComboBox = utils.getComboBoxByName("codesComboBox");
        var codeNames = new String[]{"Protection", "Chorea", "Oblivion", "Paralysing"};
        for (String code : codeNames) {
            assert Arrays.asList(codesComboBox.contents()).contains(code);
        }
    }

    @Test
    public void testLearnParalysingAndParalyseAndRob()  {
        var v1 = new Virologist();
        v1.add(new Material());
        var v2 = new Virologist();
        v2.add(bag);
        bag.setBaseField(new Shelter());
        startFresh(new Laboratory(new Paralysing()), v1, v2);

        var searchButton = utils.getButtonFixtureByText("Search Field");
        searchButton.click();
        var codesComboBox = utils.getComboBoxByName("codesComboBox");
        assert Arrays.asList(codesComboBox.contents()).contains("Paralysing");

        codesComboBox.selectItem("Paralysing");
        codesComboBox.requireSelection("Paralysing");

        var virologistsComboBox = utils.getComboBoxByName("virologistsComboBox");
        virologistsComboBox.selectItem("v2");
        virologistsComboBox.requireSelection("v2");

        var lubricateButton = utils.getButtonFixtureByText("Lubricate");
        lubricateButton.click();

        virologistsComboBox.selectItem("v2");
        virologistsComboBox.requireSelection("v2");

        var robButton = utils.getButtonFixtureByText("Rob");
        robButton.click();

        assert Objects.equals(Round_Manager.getInstance().getVirologist("v1").getGears().get(0), bag);

        var nextRoundButton = utils.getButtonFixtureByText("Next Round");
        nextRoundButton.click();

        window.menuItem(new GenericTypeMatcher<>(JMenuItem.class) {
            protected boolean isMatching(JMenuItem item) {
                return item.getText().contains("Paralysed");
            }
        });
    }

    @Test
    public void testLearnCode() {
        startFresh(new Laboratory(new Protection()), new Virologist(), new Virologist());
        var searchButton = utils.getButtonFixtureByText("Search Field");
        searchButton.click();
        var codesComboBox = utils.getComboBoxByName("codesComboBox");
        assert Arrays.asList(codesComboBox.contents()).contains("Protection");
    }

    @Test
    public void testAxePickupAndKill() {
        startFreshWithShelter(axe, new Virologist(), new Virologist());
        var searchButton = utils.getButtonFixtureByText("Search Field");
        searchButton.click();
        assert Objects.equals(Round_Manager.getInstance().getVirologist("v1").getGears().get(0), axe);

        var virologistsComboBox = utils.getComboBoxByName("virologistsComboBox");
        virologistsComboBox.selectItem("v2");

        var axeButton = utils.getButtonFixtureByText("Axe");
        axeButton.click();
        assert Objects.equals(Round_Manager.getInstance().getVirologists().size(), 1);
    }

    public void startFreshWithShelter(Gear gear, Virologist v1, Virologist v2) {
        var shelter = new Shelter();
        shelter.addGear(gear);
        startFresh(shelter, v1, v2);
        gear.setBaseField(shelter);
    }

    public void startFresh(Field field, Virologist v1, Virologist v2) {
        Round_Manager.setInstance(null);
        var rm = Round_Manager.getInstance(0);

        field.accept(v1);
        v1.setField(field);
        rm.addVirologists("v1", v1);

        field.accept(v2);
        v2.setField(field);
        rm.addVirologists("v2", v2);

        rm.addField("a field", field);

        for (int i = 0; i < 49; i++) {
            switch (i % 4) {
                case 0 -> {
                    var f1 = new Shelter();
                    rm.addField("sh" + i, f1);
                }
                case 1 -> {
                    var f2 = new Storage();
                    rm.addField("st" + i, f2);
                }
                case 2 -> {
                    var f3 = new Laboratory(new Protection());
                    rm.addField("l" + i, f3);
                }
                case 3 -> {
                    var f4 = new FreeField();
                    rm.addField("f" + i, f4);
                }
            }
        }

        var frame = GuiActionRunner.execute(GameFrame::new);
        window = new FrameFixture(robot(), frame);
        utils = new UITestUtils(window);
    }

    @Override
    protected void onSetUp() {
    }
}