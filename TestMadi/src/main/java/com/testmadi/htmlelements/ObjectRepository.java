package com.testmadi.htmlelements;

public class ObjectRepository {
	public static final String userNameTextBox = "//*[@id='login-container']/form/fieldset/div[1]/input";
    public static final String passWordTextBox = "//*[@id='login-container']/form/fieldset/div[2]/input";
    public static final String loginButton = "//*[@id='login-container']/form/fieldset/div[4]/input";
    
    
    
    
    public static final String inCorrectUserNamePasswordLabel = "#ErrorMessageDiv";
    public static final String loginFrame = "wfcPage";

    // DashBoard Page Locators
    public static final String dashBoardKronosLogo = "//*[@id='logo_link']";
    public static final String signOutLink = "profileSignOut_button";
    public static final String myTilesLabel = "tileLabel";
    public static final String tileLibraryButton = "tileLibraryButton";

    // ******************Tile Library Locators*****************************
    public static final String openCreateChartButton = "//*[@id='tileLibrary']/div[2]/div[4]/a/span";

    // *[@id='trifoldDefine']/div[2]/div[2]

    // Create Chart
    public static final String chartNameTextBox = "//*[@id='trifoldDefine']/div[2]/input";
    public static final String verticalChartButton = "//*[@id='trifoldDefine']/div[2]/div[2]/label";
    public static final String horizontalChartButton = "//*[@id='trifoldDefine']/div[2]/div[3]/label";
    public static final String pieChartButton = "//*[@id='trifoldDefine']/div[2]/div[5]/label";
    public static final String lineChartButton = "//*[@id='trifoldDefine']/div[2]/div[4]/label";
    public static final String selectDataViewDropDown = "//*[@id='trifoldDefine']/div[2]/div[1]/span[2]";
    public static final String dataViewDropDownP1 = "//*[@id='trifoldDefine']/div[2]/div[1]/div/ul/li[";
    public static final String dataViewDropDownP2 = "]";

    // plotvalues
    public static final String chartXAxisDropDown = "chartxAxis";
    public static final String chartYAxisDropDown = "chartyAxis";
    public static final String chartLimit = "//*[@id='trifoldPlot']/div[2]/div[4]/select[1]";
    public static final String chartLimitValue = "//*[@id='trifoldPlot']/div[2]/div[4]/select[2]";
    // public static final String chartLimit = "chartLimitType";
    // public static final String chartLimitValue = "chartLimitCount";

    public static final String displaySettingsLink = "//*[@id='trifoldPlot']/div[2]/div[6]/h4";

    // checkboxes
    public static final String groupOtherCheckBox = "groupOther";
    public static final String showTitleCheckBox = "trifoldShowTitle";
    public static final String showXAxisCheckBox = "trifoldXAxis";
    public static final String showYAxisCheckBox = "trifoldYAxis";
    public static final String showAxisLabels = "trifoldAxisLabels";
    public static final String showDataLabels = "trifoldValues";
    public static final String chartSaveButton = "//*[@id='trifoldTitle']/div[1]/button";
    // ******************Tile Library
    // Locators***********************************************************************************8

    // ***************************************DataView
    // Page*********************************

    public static final String showHideDataViewDashBoardButton = "apps.ia.dashboard.actions.viewDashboard";
    public static final String showHideColumnsButton = "//*[@id='genie.toolbar.actions.view']/div[2]/button";
    public static final String dataViewSaveButton = "//*[@id='genie.toolbar.actions.page.savebutton']/button";
    public static final String dataViewFilterButton = "com.kronos.wfc.ngui.dataview.filter";
    public static final String dataViewHeaderName = "/html/body/div[1]/main/div/div/div/div[1]/div[1]/div[1]/div[1]/div/div/div/span";

    public static final String dataViewShareButton = "//*[@id='com.kronos.dataview.share']/button";
    public static final String dataViewExportToCsVButton = "//*[@id='com.kronos.dataview.share.export']/a";
    public static final String dataViewPrintButton = "//*[@id='com.kronos.dataview.share.print']/a";

    // **************************** DataView Manager Page
    // Locators*************************************

    // ****************GENERAL(APPLIES TO BOTH)********************
    public static final String dataViewNameP1 = "//html/body/div[1]/div[3]/div/div/div[2]/div[";
    public static final String dataViewNameP2 = "]/div[1]/div[1]/div[1]/div[2]";
    public static final String dataViewCheckP1 = "//html/body/div[1]/div[3]/div/div/div[2]/div[";
    public static final String dataViewCheckP2 = "]/div[1]/div[1]/div[1]/div[2]";
    public static final String dropDownButtonP1 = "//html/body/div[1]/div[3]/div/div/div[2]/div[";
    public static final String dropDownButtonP2 = "]/div[1]/div[1]/div[2]/button";
    public static final String dropDownDataP1 = "//html/body/div[1]/div[3]/div/div/div[2]/div[";
    public static final String dropDownDataP2 = "]/div[2]/div";
    public static final String titleAttributeName = "title";
    public static final String checkForDataViewOnDataviewManagerPage = "/html/body/div[1]/main/div/div/div/div[3]/div[1]/div[1]/div/div";
    public static final String dataViewRows = "div[class^='ui-grid-header-cell ui-grid-clearfix ng-scope ng-isolate-scope title']"; 

    // ************************PEOPLE LOCATORS******************************
    public static final String peopleDataViewName = "i.dataview-entity";
    public static final String peopleDataViewCheckP1 = "//html/body/div[1]/div[3]/div/div/div[2]/div[";
    public static final String peopleDataViewCheckP2 = "]/div[1]/div[1]/div[1]/div[1]/i[2]";
    public static final String peopleAttributeName = "data-icon";
    public static final String peopleIconName = "PEOPLE";
    public static final String peopleIcon = ".show-emp";

    // *********************ORGANIZATION LOCATORS***************************
    public static final String organizationDataViewName = "i.dataview-entity";
    public static final String organizationDataViewCheckP1 = "//html/body/div[1]/div[3]/div/div/div[2]/div[";
    public static final String organizationDataViewCheckP2 = "]/div[1]/div[1]/div[1]/div[1]/i[2]";
    public static final String organizationAttributeName = "data-icon";
    public static final String organizationIconName = "ORGANIZATION";
    public static final String organizationIcon = ".show-org";

    // Show All
    public static final String dataViewManagerShowAllButton = "//html/body/div[1]/div[3]/div/div/div[1]/div/label[1]";

    // ###########################TimeCardLocators###########################
    public static final String timeCardHeader = "//*[@id='jqxGrid0']";
    public static final String timeCardFirstColumn = "//*[@id='columntablejqxGrid0']/div[3]/div/div[1]/div";
    public static final String timeCardInPunchFirstRow = "//*[@id='column-inPunch-Row-1']";
    public static final String timeCardOutPunchFirstRow = "//*[@id='column-outPunch-Row-1']";//
    public static final String timeCardEditorInPunchFirstRow = "templateeditorjqxGrid0inPunch";
    public static final String timeCardEditorOutPunchFirstRow = "templateeditorjqxGrid0outPunch";
    public static final String timeCardSaveButton = "saveButton";
}
