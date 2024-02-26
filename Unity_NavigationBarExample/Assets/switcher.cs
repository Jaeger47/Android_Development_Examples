using UnityEngine;
using UnityEngine.UI;

public class switcher : MonoBehaviour
{
    public GameObject[] panels;
    public Button[] buttons;

    public void SwitchPanel(int panelIndex)
    {
        DeactivateAllPanels();
        SetAllButtonsOpacity(0.5f);

        panels[panelIndex].SetActive(true);
        SetButtonOpacity(buttons[panelIndex], 1.0f);
    }

    private void DeactivateAllPanels()
    {
        foreach (GameObject panel in panels)
        {
            panel.SetActive(false);
        }
    }

    private void SetAllButtonsOpacity(float opacity)
    {
        foreach (Button button in buttons)
        {
            SetButtonOpacity(button, opacity);
        }
    }

    private void SetButtonOpacity(Button button, float opacity)
    {
        Image buttonImage = button.GetComponent<Image>();
        Color currentColor = buttonImage.color;
        currentColor.a = opacity;
        buttonImage.color = currentColor;
    }
}
