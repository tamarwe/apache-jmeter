package com.ibm.issw.odc.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.apache.commons.lang3.StringUtils;
import org.apache.jmeter.config.ConfigTestElement;
import org.apache.jmeter.config.gui.AbstractConfigGui;
import org.apache.jmeter.gui.util.HorizontalPanel;
import org.apache.jmeter.protocol.http.config.gui.UrlConfigGui;
import org.apache.jmeter.protocol.http.sampler.HTTPSamplerBase;
import org.apache.jmeter.testelement.AbstractTestElement;
import org.apache.jmeter.testelement.TestElement;
import org.apache.jmeter.testelement.property.BooleanProperty;
import org.apache.jmeter.testelement.property.StringProperty;
import org.apache.jmeter.util.JMeterUtils;
import org.apache.jorphan.gui.JLabeledTextField;

/**
 * 
 * @author ODC - On Demand Consulting
 *
 */
public class BPMHttpDefaultsGui extends AbstractConfigGui {

    private static final long serialVersionUID = 240L;

    private JCheckBox imageParser;
    
    private JCheckBox concurrentDwn;
    
    private JTextField concurrentPool; 

    private BPMUrlConfigGui urlConfig;

    private JLabeledTextField embeddedRE; // regular expression used to match against embedded resource URLs

    public BPMHttpDefaultsGui() {
        super();
        init();
    }

    @Override
    public String getLabelResource() {
        return "odc_start_bpd_title"; // $NON-NLS-1$
    }

    /**
     * @see org.apache.jmeter.gui.JMeterGUIComponent#createTestElement()
     */
    @Override
    public TestElement createTestElement() {
        ConfigTestElement config = new ConfigTestElement();
        modifyTestElement(config);
        return config;
    }

    /**
     * Modifies a given TestElement to mirror the data in the gui components.
     *
     * @see org.apache.jmeter.gui.JMeterGUIComponent#modifyTestElement(TestElement)
     */
    @Override
    public void modifyTestElement(TestElement config) {
        ConfigTestElement cfg = (ConfigTestElement ) config;
        ConfigTestElement el = (ConfigTestElement) urlConfig.createTestElement();
        cfg.clear(); // need to clear because the
        cfg.addConfigElement(el);
        super.configureTestElement(config);
        if (imageParser.isSelected()) {
            config.setProperty(new BooleanProperty(HTTPSamplerBase.IMAGE_PARSER, true));
            enableConcurrentDwn(true);
        } else {
            config.removeProperty(HTTPSamplerBase.IMAGE_PARSER);
            enableConcurrentDwn(false);
            
        }
        if (concurrentDwn.isSelected()) {
            config.setProperty(new BooleanProperty(HTTPSamplerBase.CONCURRENT_DWN, true));
        } else {
            // The default is false, so we can remove the property to simplify JMX files
            // This also allows HTTPDefaults to work for this checkbox
            config.removeProperty(HTTPSamplerBase.CONCURRENT_DWN);
        }
        if(!StringUtils.isEmpty(concurrentPool.getText())) {
            config.setProperty(new StringProperty(HTTPSamplerBase.CONCURRENT_POOL,
                    concurrentPool.getText()));
        } else {
            config.setProperty(new StringProperty(HTTPSamplerBase.CONCURRENT_POOL,
                    String.valueOf(HTTPSamplerBase.CONCURRENT_POOL_SIZE)));
        }
        if (!StringUtils.isEmpty(embeddedRE.getText())) {
            config.setProperty(new StringProperty(HTTPSamplerBase.EMBEDDED_URL_RE,
                    embeddedRE.getText()));
        } else {
            config.removeProperty(HTTPSamplerBase.EMBEDDED_URL_RE);
        }
    }

    /**
     * Implements JMeterGUIComponent.clearGui
     */
    @Override
    public void clearGui() {
        super.clearGui();
        urlConfig.clear();
        imageParser.setSelected(false);
        concurrentDwn.setSelected(false);
        concurrentPool.setText(String.valueOf(HTTPSamplerBase.CONCURRENT_POOL_SIZE));
        embeddedRE.setText(""); // $NON-NLS-1$
    }

    @Override
    public void configure(TestElement el) {
        super.configure(el);
        urlConfig.configure(el);
        imageParser.setSelected(((AbstractTestElement) el).getPropertyAsBoolean(HTTPSamplerBase.IMAGE_PARSER));
        concurrentDwn.setSelected(((AbstractTestElement) el).getPropertyAsBoolean(HTTPSamplerBase.CONCURRENT_DWN));
        concurrentPool.setText(((AbstractTestElement) el).getPropertyAsString(HTTPSamplerBase.CONCURRENT_POOL));
        embeddedRE.setText(((AbstractTestElement) el).getPropertyAsString(HTTPSamplerBase.EMBEDDED_URL_RE, ""));
    }

    private void init() {
        setLayout(new BorderLayout(0, 5));
        setBorder(makeBorder());

        add(makeTitlePanel(), BorderLayout.NORTH);

        urlConfig = new BPMUrlConfigGui(false, true, false);
        add(urlConfig, BorderLayout.CENTER);

        // OPTIONAL TASKS
        final JPanel embeddedRsrcPanel = new HorizontalPanel();
        embeddedRsrcPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), JMeterUtils
                .getResString("web_testing_retrieve_title"))); // $NON-NLS-1$

        imageParser = new JCheckBox(JMeterUtils.getResString("web_testing_retrieve_images")); // $NON-NLS-1$
        embeddedRsrcPanel.add(imageParser);
        imageParser.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(final ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) { enableConcurrentDwn(true); }
                else { enableConcurrentDwn(false); }
            }
        });
        // Concurrent resources download
        concurrentDwn = new JCheckBox(JMeterUtils.getResString("web_testing_concurrent_download")); // $NON-NLS-1$
        concurrentDwn.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(final ItemEvent e) {
                if (imageParser.isSelected() && e.getStateChange() == ItemEvent.SELECTED) { concurrentPool.setEnabled(true); }
                else { concurrentPool.setEnabled(false); }
            }
        });
        concurrentPool = new JTextField(2); // 2 columns size
        concurrentPool.setMinimumSize(new Dimension(10,20));
        concurrentPool.setMaximumSize(new Dimension(30,20));
        embeddedRsrcPanel.add(concurrentDwn);
        embeddedRsrcPanel.add(concurrentPool);
        
        // Embedded URL match regex
        embeddedRE = new JLabeledTextField(JMeterUtils.getResString("web_testing_embedded_url_pattern"),20); // $NON-NLS-1$
        embeddedRsrcPanel.add(embeddedRE);

        
        add(embeddedRsrcPanel, BorderLayout.SOUTH);
    }

    @Override
    public Dimension getPreferredSize() {
        return getMinimumSize();
    }
    
    private void enableConcurrentDwn(final boolean enable) {
        if (enable) {
            concurrentDwn.setEnabled(true);
            embeddedRE.setEnabled(true);
            if (concurrentDwn.isSelected()) {
                concurrentPool.setEnabled(true);
            }
        } else {
            concurrentDwn.setEnabled(false);
            concurrentPool.setEnabled(false);
            embeddedRE.setEnabled(false);
        }
    }

    public void itemStateChanged(final ItemEvent event) {
        if (event.getStateChange() == ItemEvent.SELECTED) {
            enableConcurrentDwn(true);
        } else {
            enableConcurrentDwn(false);
        }
    }
}
