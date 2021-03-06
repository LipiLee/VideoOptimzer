package com.att.aro.ui.model.bestpractice;

import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import com.att.aro.core.bestpractice.pojo.ImageMdataEntry;
import com.att.aro.ui.model.DataTableModel;
import com.att.aro.ui.model.NumberFormatRenderer;
import com.att.aro.ui.utils.ResourceBundleHelper;

/**
 * Represents the data table model for text Image Size result table. This
 * class implements the aro.commonui.DataTableModel class using ImageSizeEntry
 * objects.
 */
public class ImageFormatTableModel extends DataTableModel<ImageMdataEntry> {

	private static final long serialVersionUID = 1L;

	private static final Logger LOGGER = Logger.getLogger(ImageFormatTableModel.class.getName());

	private static final int COL1_MIN = 70;
	private static final int COL1_MAX = 100;
	private static final int COL1_PREF = 70;

	private static final int COL2_MIN = 300;
	private static final int COL2_PREF = 300;

	private static final int COL3_MIN = 80;
	private static final int COL3_MAX = 120;
	private static final int COL3_PREF = 80;

	private static final int COL4_MIN = 80;
	private static final int COL4_MAX = 120;
	private static final int COL4_PREF = 80;
	
	private static final int COL5_MIN = 80;
	private static final int COL5_MAX = 120;
	private static final int COL5_PREF = 80;

	private static final int COL_1 = 0;
	private static final int COL_2 = 1;
	private static final int COL_3 = 2;
	private static final int COL_4 = 3;
	private static final int COL_5 = 4;
	private static final String[] COLUMNS = { ResourceBundleHelper.getMessageString("imageFormat.table.col1"),
											  ResourceBundleHelper.getMessageString("imageFormat.table.col2"),
											  ResourceBundleHelper.getMessageString("imageFormat.table.col3"),
											  ResourceBundleHelper.getMessageString("imageFormat.table.col4"),
											  ResourceBundleHelper.getMessageString("imageFormat.table.col5")};

	/**
	 * Initializes a new instance of the ImageSizeTableModel.
	 */
	public ImageFormatTableModel() {
		super(ImageFormatTableModel.COLUMNS);
	}

	/**
	 * Returns a TableColumnModel that is based on the default table column
	 * model for the DataTableModel class. The TableColumnModel returned by this
	 * method has the same number of columns in the same order and structure as
	 * the table column model in the DataTableModel. When a DataTable object is
	 * created, this method is used to create the TableColumnModel if one is not
	 * specified. This method may be overridden in order to provide
	 * customizations to the default column model, such as providing a default
	 * column width and/or adding column renderers and editors.
	 * 
	 * @return TableColumnModel object
	 */
	@Override
	public TableColumnModel createDefaultTableColumnModel() {
		TableColumnModel cols = super.createDefaultTableColumnModel();
		TableColumn col;

		col = cols.getColumn(ImageFormatTableModel.COL_1);
		col.setCellRenderer(new NumberFormatRenderer(new DecimalFormat("0.000")));
		col.setMinWidth(ImageFormatTableModel.COL1_MIN);
		col.setPreferredWidth(ImageFormatTableModel.COL1_PREF);
		col.setMaxWidth(ImageFormatTableModel.COL1_MAX);

		col = cols.getColumn(ImageFormatTableModel.COL_2);
		col.setMinWidth(ImageFormatTableModel.COL2_MIN);
		col.setPreferredWidth(ImageFormatTableModel.COL2_PREF);
		//col.setMaxWidth(ImageCompressionTableModel.COL2_MAX);

		col = cols.getColumn(ImageFormatTableModel.COL_3);
		col.setMinWidth(ImageFormatTableModel.COL3_MIN);
		col.setPreferredWidth(ImageFormatTableModel.COL3_PREF);
		col.setMaxWidth(ImageFormatTableModel.COL3_MAX);

		col = cols.getColumn(ImageFormatTableModel.COL_4);
		col.setMinWidth(ImageFormatTableModel.COL4_MIN);
		col.setPreferredWidth(ImageFormatTableModel.COL4_PREF);
		col.setMaxWidth(ImageFormatTableModel.COL4_MAX);
		
		col = cols.getColumn(ImageFormatTableModel.COL_5);
		col.setMinWidth(ImageFormatTableModel.COL5_MIN);
		col.setPreferredWidth(ImageFormatTableModel.COL5_PREF);
		col.setMaxWidth(ImageFormatTableModel.COL5_MAX);

		return cols;
	}

	/**
	 * Returns a class representing the specified column. This method is
	 * primarily used to sort numeric columns.
	 * 
	 * @param columnIndex
	 *            The index of the specified column.
	 * 
	 * @return A class representing the specified column.
	 * 
	 * @see javax.swing.table.AbstractTableModel#getColumnClass(int)
	 */
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		ImageFormatTableModel.LOGGER.log(Level.FINE, "getColumnClass, idx: {0}", columnIndex);
		switch (columnIndex) {
		case COL_1:
			return Double.class;
		case COL_2:
			return String.class;
		case COL_3:
			return Double.class;
		case COL_4:
			return Double.class;
		case COL_5:
			return String.class;
		default:
			return super.getColumnClass(columnIndex);
		}
	}

	/**
	 * Defines how the data object managed by this table model is mapped to its
	 * columns when displayed in a row of the table.
	 * 
	 * @param item
	 *            An object containing the column information.
	 * @param columnIndex
	 *            The index of the specified column.
	 * 
	 * @return The table column value calculated for the object.
	 */
	@Override
	protected Object getColumnValue(ImageMdataEntry item, int columnIndex) {
		ImageFormatTableModel.LOGGER.log(Level.FINEST, "getColumnValue, idx:{0}", columnIndex);
		switch (columnIndex) {
		case COL_1:
			return item.getTimeStamp();
		case COL_2:
			return item.getHttpObjectName();
		case COL_3:
			return item.getImageSize();
		case COL_4:
			return item.getFormattedSize();
		case COL_5:
		return item.getPercentSavings();
		default:
			return null;
		}
	}

}
